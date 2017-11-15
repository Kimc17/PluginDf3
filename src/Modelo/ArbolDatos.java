package Modelo;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

import Estructuras.ListaSimple;
import Estructuras.MethodVisitor;
import Estructuras.NodoSimple;
import Estructuras.listaDoble;

public class ArbolDatos {

	listaDoble  metodos;

	public ArbolDatos() {
		this.metodos= new listaDoble("lista metodos");
		
		
		
	}

	public listaDoble Raiz(MethodVisitor visitor) {
		System.out.println("Creacion de raiz iniciada");

	for (MethodDeclaration method : visitor.getMethods()) {
		
		ListaSimple statements= new ListaSimple();
		statements.setName(method.getName().toString());
		
		Metodos(method, statements);
		statements.Print();
    }
	return metodos; 
	

	}
		
		
	private void Metodos(MethodDeclaration method, ListaSimple statements) {
	
        	List ListaStatements  = method.getBody().statements();
        	Separar(ListaStatements, statements) ;
		
        		
	}


	private void Separar(List ListaStatements, ListaSimple statements) {
		

		
		int index=0;
    	while (index <= ListaStatements.size()-1) {
    			
    		VerTipo(ListaStatements.get(index), statements);
    		
    		index ++;
    	}
    	metodos.agregarAlFinal(statements, statements.getName());
	}


	private void VerTipo(Object object, ListaSimple statements) {
	
		String si="";
		String no="";
		String expression="";
		String body="";
		String tipo="";
		
		
		if (object instanceof IfStatement) {
			System.out.println("Es un if");
			
			

			
			tipo ="if";
			IfStatement temp= (IfStatement) object;
	
			expression= temp.getExpression().toString();
			si=temp.getThenStatement().toString();
			
			no= temp.getElseStatement().toString();

		}
		
		
		else if (object instanceof ForStatement ) {
			System.out.println("Es un for");
			tipo= "for";
			ForStatement temp= (ForStatement) object;
			
			String expresion= temp.getExpression().toString();
			Block var = (Block) temp.getBody();
			List var2= var.statements();
			expression= "";
    				
    				
			List inicializadores =temp.initializers();
			List updaters= temp.updaters();

				
			body= temp.getBody().toString();
			
			int index=0;
		
			while (index< inicializadores.size()){
				
				expression +="   " + inicializadores.get(index).toString();
				index++;	
			} 
			expression+="  "+ expresion.toString();
		
			
			int index2=0;
			
			
			while (index2< updaters.size()){
				
				expression +="   " + updaters.get(index2).toString();
				index2++;	
			}
		}
		else if (object instanceof WhileStatement ) {
			System.out.println("Es un while");
			tipo= "while";
			WhileStatement temp= (WhileStatement) object;
			
			body= temp.getBody().toString();
			expression =temp.getExpression().toString();
			
	
		}
		else if (object instanceof DoStatement ) {
			System.out.println("Es un Do");
			DoStatement temp= (DoStatement) object;
			tipo="Do";
			body=temp.getBody().toString();
			expression=temp.getExpression().toString();
		
			
		}
		else if (object instanceof TryStatement ) {
			System.out.println("Es un Try");
			TryStatement temp= (TryStatement) object;
			tipo= "try";
			body=temp.getBody().toString();
			expression=temp.getFinally().toString();
	
		}
		
		else if (object instanceof SwitchStatement ) {
			System.out.println("Es un Switch");
			SwitchStatement temp= (SwitchStatement) object;
			expression=temp.getExpression().toString();
		
			
		}
		
		statements.agregarAlFinal(object, si, no, expression, body, tipo);
		
	}

	
	

}
	

