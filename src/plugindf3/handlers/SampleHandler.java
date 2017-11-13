package plugindf3.handlers;

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

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
ArbolDatos arbol = new ArbolDatos();
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
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
	
}
