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

import Control.ArbolNArio;
import Control.ListaSimple;
import Control.MethodVisitor;
import Control.NodoArbolNArio;

public class ArbolDatos {
	
	ArbolNArio arbol;
	ListaSimple<String> metodos;
	public ArbolDatos() {
		this.arbol = new ArbolNArio<>();
		this.metodos = new ListaSimple<>();
	}

	public void Raiz(MethodVisitor visitor) {
		System.out.println("Creacion de raiz iniciada");
		NodoArbolNArio raiz = new NodoArbolNArio(visitor);
		raiz.setNombre(visitor.toString());
		raiz.setTipo("clase");
		arbol.definirRaiz(raiz);
		
		
		
	for (MethodDeclaration method : visitor.getMethods()) {
		metodos.agregarAlFinal(method.getName().toString());	
		Metodos(method, raiz);
		
    } 
	metodos.Print();
	}
		
		
	private void Metodos(MethodDeclaration method, NodoArbolNArio raiz) {
	
        	List ListaStatements  = method.getBody().statements();
        	NodoArbolNArio metodoHijo = new NodoArbolNArio(method);
        	 metodoHijo.setNombre(method.getName().toString());
        	 metodoHijo.setTipo("metodo");
        	raiz.agregarHijo(metodoHijo);
        	Separar(ListaStatements, metodoHijo);
		
        		
	}


	private void Separar(List ListaStatements, NodoArbolNArio metodoHijo) {
		
		
		
		
		
		int index=0;
    	while (index < ListaStatements.size()) {
    		
    		NodoArbolNArio statementHijo = new NodoArbolNArio(ListaStatements.get(index));
    		statementHijo.setNombre(ListaStatements.get(index).toString());
    		statementHijo.setTipo("statement");
    		metodoHijo.agregarHijo(statementHijo);
    		
    		
    		
    		System.out.println("indice  "+ index +"   "+ ListaStatements.get(index));
    		
    		VerTipo(ListaStatements.get(index), statementHijo);
    		index ++;
    	}
	}


	private void VerTipo(Object object, NodoArbolNArio statementHijo) {
		
		if (object instanceof IfStatement) {
			
			
			NodoArbolNArio elseHijo;;
			
    		
			
			
			System.out.println("Es un if");
			IfStatement temp= (IfStatement) object;
	
			String expresion= temp.getExpression().toString();
			String then=temp.getThenStatement().toString();
			String part0 =temp.getElseStatement().toString();
			
			
			
			String[] part= part0.split("}");
			String Else = part[0];
			
	
			
			
			NodoArbolNArio ElseHijo = new NodoArbolNArio(Else);
    		statementHijo.setTipo("else");
    		statementHijo.agregarHijo(ElseHijo);
    		
    		
			NodoArbolNArio expresionHijo = new NodoArbolNArio(expresion);
    		statementHijo.setTipo("expresion");
    		statementHijo.agregarHijo(expresionHijo);
    		
    		NodoArbolNArio thenHijo = new NodoArbolNArio(then);
    		statementHijo.setTipo("then");
    		statementHijo.agregarHijo(expresionHijo);
    		
    		
		}
		
		
		else if (object instanceof ForStatement ) {
			System.out.println("Es un for");
			ForStatement temp= (ForStatement) object;
			
			Expression expresion= temp.getExpression();
			Statement body = temp.getBody();
			String condicion= "";
			
			
			
    		NodoArbolNArio bodyHijo = new NodoArbolNArio(body);
    		statementHijo.setTipo("body");
    		statementHijo.agregarHijo(bodyHijo);
    				
    				
			List inicializadores =temp.initializers();
			List updaters= temp.updaters();
			
			
			int index=0;
			while (index< inicializadores.size()){
				
				condicion +="   " + inicializadores.get(index).toString();
				index++;	
			} 
			condicion +="  "+ expresion.toString();
		
			
			int index2=0;
			
			
			while (index2< updaters.size()){
				
				condicion +="   " + updaters.get(index2).toString();
				index2++;	
			}
			NodoArbolNArio condicionHijo = new NodoArbolNArio(condicion);
    		statementHijo.setTipo("condicion");
    		statementHijo.agregarHijo(condicionHijo );
    		
			

		}
		else if (object instanceof WhileStatement ) {
			System.out.println("Es un while");
			WhileStatement temp= (WhileStatement) object;
			
			String body= temp.getBody().toString();
			String expresion =temp.getExpression().toString();
			
			NodoArbolNArio bodyHijo = new NodoArbolNArio(body);
    		statementHijo.setTipo("body");
    		statementHijo.agregarHijo(bodyHijo );
    		
    		
    		NodoArbolNArio expresionHijo = new NodoArbolNArio(expresion);
    		statementHijo.setTipo("expresion");
    		statementHijo.agregarHijo(expresionHijo);
		}
		else if (object instanceof DoStatement ) {
			System.out.println("Es un Do");
			
		}
		else if (object instanceof TryStatement ) {
			System.out.println("Es un Try");
			
		}
		
		else if (object instanceof SwitchStatement ) {
			System.out.println("Es un Switch");
			
		}
		else {
			System.out.println("No es ninguno");
			return;
			
		}
		
		
	}
	
	public ListaSimple getMetodos() {
		return metodos;
	}
}
	

