package org.example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cau3 {
    public static void main(String[] args) throws FileNotFoundException {
        JavaParser javaParser = new JavaParser();
        FileInputStream fileInputStream = new FileInputStream("E:\\HK2_Nam4\\Kien_Truc_Phan_Mem\\Thuc_Hanh\\Lab02\\Java\\src\\main\\java\\org\\example\\Person.java");
        ParseResult<CompilationUnit> cu = javaParser.parse(fileInputStream);

        if (cu.getResult().isPresent()) {
            CompilationUnit compilationUnit = cu.getResult().get();
            ClassOrInterfaceDeclaration classDeclaration = compilationUnit.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);

            if (classDeclaration != null) {
                System.out.println("========fields of class");

                // Sử dụng visitor để duyệt qua lớp và xem thông tin của đối tượng Company
                classDeclaration.accept(new CompanyFieldVisitor(), null);

                System.out.println("========methods of class");
                classDeclaration.findAll(MethodDeclaration.class).forEach(m -> System.out.println(m.getName()));
            }
        }
    }

    // Visitor để duyệt qua AST và xem thông tin của đối tượng Company
    private static class CompanyFieldVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(FieldDeclaration fieldDeclaration, Void arg) {
            fieldDeclaration.getVariables().forEach(variable -> {
                System.out.println("Field Name: " + variable.getName());
                String fieldType = fieldDeclaration.getElementType().asString();

                if (fieldType.equals("Company")) {
                    System.out.println("Company Field Type: " + fieldType);

                    // Nếu là Company, kiểm tra biểu diễn tạo đối tượng và duyệt qua fields của Company
                    ObjectCreationExpr objectCreationExpr = (ObjectCreationExpr) variable.getInitializer().orElse(null);
                    if (objectCreationExpr != null) {
                        System.out.println("Company Object Creation Expression: " + objectCreationExpr);

                        // Duyệt qua các tham số của đối tượng Company
                        objectCreationExpr.findAll(ObjectCreationExpr.class).forEach(companyExpr -> {
                            companyExpr.findAll(FieldAccessExpr.class).forEach(fieldAccessExpr -> {
                                System.out.println("Company Field Access: " + fieldAccessExpr.getName());
                            });
                        });
                    }
                }
            });
        }
    }
}
