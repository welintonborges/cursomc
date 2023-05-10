package com.example.testeando.services.validation;

import com.example.testeando.domain.Cliente;
import com.example.testeando.domain.enums.TipoCliente;
import com.example.testeando.dto.ClienteNewDTO;
import com.example.testeando.exceptions.FieldMessage;
import com.example.testeando.repositories.ClienteRepository;
import com.example.testeando.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto) {

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {
            list.add(new FieldMessage("email", "E-mail já existentte"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

//        Cliente aux = repo.findByEmail(objDto.getEmail());
//        if (aux != null) {
//            list.add(new FieldMessage("email", "Email já existente"));
//        }

        for (FieldMessage e : list) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
//                    .addConstraintViolation();
        }
        return list.isEmpty();
    }


}
