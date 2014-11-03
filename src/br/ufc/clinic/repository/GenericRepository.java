package br.ufc.clinic.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class GenericRepository<T> {
	private List<T> entity;
	private String pathFile;
	private FileInputStream file;
	private FileOutputStream file2;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean load;
	
	public GenericRepository(String nome){
		this.pathFile = nome;
		this.entity = new ArrayList<T>();
		this.load = false;
	}
	
	
	public void create(){
		if(this.exist()){
			System.out.println("Repositorio existente, vou recarregar ele!!!");
			this.load();
			return;
		}
		try {
			this.file2 = new FileOutputStream(pathFile);
			this.output = new ObjectOutputStream(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void destroy(){
		if(!this.exist()){
			System.out.println("Repositorio não existe!!!");
			return;
		}
		File f = new File(this.pathFile);
		f.delete();
	};
	
	public void load(){
		if(!this.exist()){
			System.out.println("Repositorio não existe!!!");
			return;
		}
		try {
			this.file = new FileInputStream(pathFile);
			this.input = new ObjectInputStream(file);
			this.load = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void push(){
		if(!this.exist()){
			System.out.println("Repositorio não existe!!!");
			return;
		}
		try {
			this.destroy();
			this.create();
			this.output.writeObject(this.entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	@SuppressWarnings("unchecked")
	public void pull(){
		if(!this.exist()){
			System.out.println("Repositorio não existe!!!");
			return;
		}
		if(!this.isLoad()){
			System.out.println("Repositorio não foi carregado ainda!!!");
			return;
		}
		try {
			this.entity = (List<T>) input.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void add(T entity){
		this.entity.add(entity);
	};
	
	public void rem(T entity){
		this.entity.remove(entity);
	};
	
	
	public boolean exist(){
		File f = new File(this.pathFile);
		return f.exists();
	}
	
	public boolean isLoad(){
		return this.load;
	}
	
	public List<T> get(){
		return this.entity;
	}
}