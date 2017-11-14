package interfaz.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.*;

import Control.ListaSimple;
import Modelo.ArbolDatos;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import Control.ArbolNArio;
import Control.MethodVisitor;
import Modelo.ArbolDatos;


import org.eclipse.jface.dialogs.MessageDialog;


import org.eclipse.ui.*;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import javax.inject.Inject;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class PluginDF extends ViewPart {
	public PluginDF() {
		
	}
	

	public static final String ID = "interfaz.views.PluginDF";

	@Inject IWorkbench workbench;
	 

	@Override
	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		
		Button btnDiagramar = new Button(composite, SWT.NONE);
		btnDiagramar.setBounds(150, 10, 75, 25);
		btnDiagramar.setText("Diagramar");
		
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(24, 12, 91, 23);	
		combo.add("If");
		combo.add("For");
		combo.add("While");
	
		
		Canvas canvas = new Canvas(composite, SWT.NONE);
		canvas.setBounds(10, 41, 2000, 2000);
		
		Button btnLeer = new Button(composite, SWT.NONE);
		btnLeer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLeer.setBounds(252, 10, 75, 25);
		btnLeer.setText("Cargar Métodos");
		btnLeer.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				caca();
				
			}
		});
		
	    btnDiagramar.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) {
	        	canvas.redraw();
	        	canvas.addPaintListener(new PaintListener() {
					
					@Override
					public void paintControl(PaintEvent e) {
						e.gc.fillRectangle(0, 0, 2000, 2000);
						
					}
				});
	        	String tipo = combo.getText();
	        	Diagrama dele = new Diagrama(canvas, tipo);
	        	
	        	
	        }
	      });
		

	}
	
	public Object caca() {
		System.out.println("Clic detectado");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		for (IProject project : projects) {
			try {
				
				if (project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
					IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
					for (IPackageFragment mypackage : packages) {
						if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
							for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
								System.out.println("Exploracion metodos iniciada");
								CompilationUnit parse = parse(unit);
								MethodVisitor visitor = new MethodVisitor();
                                parse.accept(visitor);
                                ArbolDatos arbol= new ArbolDatos();
                                arbol.Raiz(visitor);
                                
                                
    
							}
						}
					}

				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}


	@Override
	public void setFocus() {
		
	}
}
