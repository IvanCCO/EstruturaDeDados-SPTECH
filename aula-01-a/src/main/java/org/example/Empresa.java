package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Funcionario>funcionarios;

    public Empresa(){
        funcionarios = new ArrayList<>();
    }

    //Métodos

    public void addFuncionario (Funcionario funcionario){
        funcionario.add();
    }

    public void exibirFuncionario(){
        for(Funcionario f: funcionarios){
            System.out.println(f);
        }
    }
}
