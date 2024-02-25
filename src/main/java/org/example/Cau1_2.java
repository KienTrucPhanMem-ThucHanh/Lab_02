package org.example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class Cau1_2 {
    public static void main(String[] args) throws FileNotFoundException {
        JavaParser javaParser = new JavaParser();
        FileInputStream fileInputStream = new FileInputStream("E:\\HK2_Nam4\\Kien_Truc_Phan_Mem\\Thuc_Hanh\\Lab02\\Java\\src\\main\\java\\org\\example\\Person.java");
        ParseResult<CompilationUnit> cu = javaParser.parse(fileInputStream);

        if(cu.getResult().isPresent()){

//            Câu 1
            System.out.println("========name of method");
            cu.getResult().get().findAll(MethodDeclaration.class).forEach(m -> System.out.println(m.getName()));
            System.out.println("========variables method");
            cu.getResult().get().findAll(FieldDeclaration.class).forEach(abc -> System.out.println(abc.getVariables()));

//            CompilationUnit compilationUnit = cu.getResult().get();
//            Optional<PackageDeclaration> packageDeclaration = compilationUnit.getPackageDeclaration();
//            if(packageDeclaration.isPresent()){
//                System.out.println("package" + packageDeclaration.get().getName());
//            }
//
//            ClassOrInterfaceDeclaration classOrInterfaceDeclaration = compilationUnit.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);
//            if(classOrInterfaceDeclaration != null){
//                System.out.println("Class Name: " + classOrInterfaceDeclaration.getName());
//                // Lấy Parent Node (thư mục cha)
//                System.out.println("Parent Node (Package or CompilationUnit): " + classOrInterfaceDeclaration.getParentNode());
//            }
        }
    }
}