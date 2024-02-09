package util.validator;


import model.Telefone;

public class TelefoneValidator {

    public void checkTelefone(Telefone telefone) throws Exception {
        // Remover pontuações e espaços do número de telefone
        String numeroLimpo = telefone.getNumero().replaceAll("[^0-9]", "");

        // Verificar se o número de telefone tem pelo menos um dígito
        if (numeroLimpo.length() == 0) {
            throw new Exception("Número de telefone inválido");
        }

        // Continuar com outras verificações, se necessário

        // Exemplo: Verificar se o número de telefone tem um comprimento específico
        if (numeroLimpo.length() < 10 || numeroLimpo.length() > 15) {
            throw new Exception("Número de telefone com comprimento inválido");
        }

        // Outras verificações podem ser adicionadas conforme necessário
    }
}