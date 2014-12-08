package enhance;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.lang.reflect.Method;


public class printMethodDetails {

/**
 * @param args
 * @throws Exception
 */
public static void main (String[] args) throws Exception {
    FileInputStream in = new FileInputStream("/Users/vishnurainigari/Documents/workspace/src/com.pla.chatsys.client/ClientImp.java");
    Class aClass = ClientImp.class;

    Method[] methods = aClass.getDeclaredMethods();

    for (Method method : methods) {
        //System.out.println(method.toGenericString());
    }
    CompilationUnit cu;
    try {
        // parse the file
        cu = JavaParser.parse(in);
    } finally {
        in.close();
    }

    new MethodVisitor().visit(cu, null);
    }


private static class MethodVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        System.out.println(n);
       //System.out.println(n.getName());

        //System.out.println(n.getBody());

    }
}
}