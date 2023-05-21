package org.example;
public class Banco {

    // Atributos
    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);
    // Contador de operações empilhadas
    Integer contadorOperacao = 0;

    // Métodos

    /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
       Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void debitar(Double valor, ContaBancaria conta) {


        if(conta.debitar(valor)){

            try{
                Operacao operacao = new Operacao(conta, "Débito", valor);
                pilhaOperacao.push(operacao);
                contadorOperacao++;
            }catch (Exception e){
                System.out.println(e);
            }


        }

    }

    /* Método creditar - recebe o valor a ser depositado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void creditar(Double valor, ContaBancaria conta) {

        conta.creditar(valor);

        try {

            Operacao operacao = new Operacao(conta, "Crédito", valor);
            pilhaOperacao.push(operacao);
            contadorOperacao++;
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {

        if(qtdOperacaoDesfeita == null || qtdOperacaoDesfeita == 0){
            throw new IllegalArgumentException("Você não pode desfazer essa quantidade de operações");
        }


        if(qtdOperacaoDesfeita > contadorOperacao){
            throw new IllegalArgumentException("Você não pode desfazer essa quantidade de operações");
        }


            for(int i = 0; i<qtdOperacaoDesfeita;i++){

                Operacao operacao= pilhaOperacao.pop();
                if(operacao.getTipoOperacao() == "Débito"){
                    operacao.getContaBancaria().creditar(operacao.getValor());
                }else{
                    operacao.getContaBancaria().debitar(operacao.getValor());
                }
                contadorOperacao--;

            }


    }


    private Boolean isTipoOperacaoValido(String op){
        return op == "Débito" || op == "Crédito";
    }
    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {

        if(tipoOperacao == null || valor == null || conta == null){
            throw new IllegalArgumentException("Tipo Operação não é valido");
        }

        if(!isTipoOperacaoValido(tipoOperacao)){
            throw new IllegalArgumentException("Tipo Operação não é valido");
        }

        if(valor < 0){
            throw new IllegalArgumentException("Valor não é valido");
        }

        Operacao op = new Operacao(conta, tipoOperacao, valor);

        filaOperacao.insert(op);

    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {

        if(filaOperacao.isEmpty()){
            System.out.println("Não tem nenhuma operação agendada");
        }else{


            while(!filaOperacao.isEmpty()){

                Operacao op = filaOperacao.poll();

                if(op.getTipoOperacao() == "Débito"){
                    op.getContaBancaria().debitar(op.getValor());
                }else{
                    op.getContaBancaria().creditar(op.getValor());
                }

            }

        }
    }

    // Gettens

    public PilhaObj<Operacao> getPilhaOperacao() {
        return pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return filaOperacao;
    }

    public Integer getContadorOperacao() {
        return contadorOperacao;
    }
}

