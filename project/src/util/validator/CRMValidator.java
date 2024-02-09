package util.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRMValidator {

    private static final Pattern ONLY_DIGITS_PATTERN = Pattern.compile("\\d{4,10}");

    public void validarCRM(String crm) throws Exception {
        // Remover caracteres não numéricos do CRM
        String crmLimpo = removerCaracteres(crm);

        // Verificar se o CRM possui entre 4 e 10 dígitos
        Matcher matcher = ONLY_DIGITS_PATTERN.matcher(crmLimpo);
        if (!matcher.matches()) {
            throw new Exception("CRM inválido: " + crm);
        }

    }

    private String removerCaracteres(String input) {
        return input.replaceAll("[^0-9]", "");
    }
}