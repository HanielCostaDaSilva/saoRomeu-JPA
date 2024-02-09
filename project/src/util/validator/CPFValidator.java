package util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFValidator {

    private static final Pattern ONLY_DIGITS_PATTERN = Pattern.compile("\\d{11}");

    public void validarCPF(String cpf) throws Exception {
        // Remover caracteres especiais do CPF
        String cpfLimpo = removerCaracteres(cpf);

        // Verificar se o CPF possui 11 dígitos após a remoção dos caracteres especiais
        Matcher matcher = ONLY_DIGITS_PATTERN.matcher(cpfLimpo);
        if (!matcher.matches()) {
            throw new Exception("CPF inválido: " + cpf);
        }
        try {
            Integer.parseInt(cpfLimpo);
        } catch (Exception e) {
            throw new Exception("CPF contém caracteres inválidos: " + cpf);
        }

    }

    private String removerCaracteres(String input) {
        return input.replaceAll("[^0-9]", "");
    }
}