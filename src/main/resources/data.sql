INSERT INTO endereco (cep, cidade, estado, logradouro, numero, complemento, bairro, pontoReferencia)
VALUES
    ('74730000', 'Goiânia', 'GO', 'Rua A', '123', 'Apto 101', 'Setor Central', 'Próximo ao Mercado Municipal'),
    ('74730000', 'Goiânia', 'GO', 'Rua B', '456', 'Casa 2', 'Setor Central', 'Próximo à Praça Central'),
    ('74730000', 'Goiânia', 'GO', 'Avenida C', '789', 'Sala 305', 'Setor Central', 'Em frente ao Hospital Municipal'),
    ('74730000', 'Goiânia', 'GO', 'Rua D', '321', 'Loja 5', 'Setor Central', 'Ao lado do Banco do Brasil'),
    ('74730000', 'Goiânia', 'GO', 'Avenida E', '654', 'Apto 202', 'Setor Central', 'Próximo à Estação de Ônibus'),
    ('74730000', 'Goiânia', 'GO', 'Rua F', '987', 'Casa 3', 'Setor Central', 'Em frente à Praça do Mercado'),
    ('74730000', 'Goiânia', 'GO', 'Avenida G', '852', 'Sala 401', 'Setor Central', 'Próximo ao Parque Municipal'),
    ('74730000', 'Goiânia', 'GO', 'Rua H', '369', 'Loja 8', 'Setor Central', 'Ao lado da Farmácia Popular'),
    ('74730000', 'Goiânia', 'GO', 'Avenida I', '753', 'Apto 303', 'Setor Central', 'Em frente à Escola Estadual'),
    ('74730000', 'Goiânia', 'GO', 'Rua J', '159', 'Casa 4', 'Setor Central', 'Próximo ao Supermercado ABC'),
    ('74730000', 'Goiânia', 'GO', 'Avenida K', '357', 'Sala 201', 'Setor Central', 'Ao lado da Praça da Matriz'),
    ('74730000', 'Goiânia', 'GO', 'Rua L', '852', 'Loja 12', 'Setor Central', 'Próximo ao Posto de Gasolina');

-- Inserindo registros na tabela medico
INSERT INTO medicos (Nome, Genero, DT_NASCIMENTO, cpf, rg, ESTADO_CIVIL, telefone, email, naturalidade, senha, especializacao_clinica, crm)
VALUES
    ('Médico1', 'Masculino', TO_DATE('1980-01-01', 'YYYY-MM-DD'), '11111111111', '1234567', 'Solteiro(a)', '1111111111', 'medico1@example.com', 'Naturalidade1', 'senha1', 'Especialização1', 'CRM1'),
    ('Médico2', 'Feminino', TO_DATE('1975-02-02', 'YYYY-MM-DD'), '22222222222', '2345678', 'Casado(a)', '2222222222', 'medico2@example.com', 'Naturalidade2', 'senha2', 'Especialização2', 'CRM2'),
    ('Médico3', 'Masculino', TO_DATE('1985-03-03', 'YYYY-MM-DD'), '33333333333', '3456789', 'Solteiro(a)', '3333333333', 'medico3@example.com', 'Naturalidade3', 'senha3', 'Especialização3', 'CRM3'),
    ('Médico4', 'Feminino', TO_DATE('1982-04-04', 'YYYY-MM-DD'), '44444444444', '4567890', 'Casado(a)', '4444444444', 'medico4@example.com', 'Naturalidade4', 'senha4', 'Especialização4', 'CRM4');


-- Inserindo registros na tabela paciente
INSERT INTO paciente (Nome, Genero, DT_NASCIMENTO, cpf, rg, ESTADO_CIVIL, telefone, email, naturalidade, contato_emergencia, lista_alergias, lista_cuidados, convenio, numero_convenio, validade_convenio, endereco_id)
VALUES
    ('Paciente1', 'Masculino', TO_DATE('1990-01-01', 'YYYY-MM-DD'), '11111111111', '1234567', 'Solteiro(a)', '1111111111', 'paciente1@example.com', 'Naturalidade1', 'Contato1', 'Alergia1', 'Cuidados1', 'Convenio1', '12345', TO_DATE('2025-12-31', 'YYYY-MM-DD'), 1),
    ('Paciente2', 'Feminino', TO_DATE('1985-02-02', 'YYYY-MM-DD'), '22222222222', '2345678', 'Casado(a)', '2222222222', 'paciente2@example.com', 'Naturalidade2', 'Contato2', 'Alergia2', 'Cuidados2', 'Convenio2', '67890', TO_DATE('2024-06-30', 'YYYY-MM-DD'), 2),
    ('Paciente3', 'Masculino', TO_DATE('1995-03-03', 'YYYY-MM-DD'), '33333333333', '3456789', 'Solteiro(a)', '3333333333', 'paciente3@example.com', 'Naturalidade3', 'Contato3', 'Alergia3', 'Cuidados3', 'Convenio3', '54321', TO_DATE('2023-09-15', 'YYYY-MM-DD'), 3),
    ('Paciente4', 'Feminino', TO_DATE('1992-04-04', 'YYYY-MM-DD'), '44444444444', '4567890', 'Casado(a)', '4444444444', 'paciente4@example.com', 'Naturalidade4', 'Contato4', 'Alergia4', 'Cuidados4', 'Convenio4', '98765', TO_DATE('2025-02-28', 'YYYY-MM-DD'), 4),
    ('Paciente5', 'Masculino', TO_DATE('1988-05-05', 'YYYY-MM-DD'), '55555555555', '5678901', 'Solteiro(a)', '5555555555', 'paciente5@example.com', 'Naturalidade5', 'Contato5', 'Alergia5', 'Cuidados5', 'Convenio5', '23456', TO_DATE('2024-11-20', 'YYYY-MM-DD'), 5),
    ('Paciente6', 'Feminino', TO_DATE('1997-06-06', 'YYYY-MM-DD'), '66666666666', '6789012', 'Casado(a)', '6666666666', 'paciente6@example.com', 'Naturalidade6', 'Contato6', 'Alergia6', 'Cuidados6', 'Convenio6', '65432', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 6)


-- Inserindo registros na tabela medicamentos
INSERT INTO medicamentos (nome, dtAdministracao, tipo, quantidade, unidade, obs, paciente_ie, medico_id)
VALUES
    ('Medicamento1', TO_DATE('2023-01-01', 'YYYY-MM-DD'), 'Tipo1', 5, 'Comprimidos', 'Observação1', 1, 1),
    ('Medicamento2', TO_DATE('2023-02-02', 'YYYY-MM-DD'), 'Tipo2', 3, 'Cápsulas', 'Observação2', 2, 2),
    ('Medicamento3', TO_DATE('2023-03-03', 'YYYY-MM-DD'), 'Tipo1', 2, 'Injeções', 'Observação3', 3, 3),
    ('Medicamento4', TO_DATE('2023-04-04', 'YYYY-MM-DD'), 'Tipo3', 1, 'Frascos', 'Observação4', 4, 4),
    ('Medicamento5', TO_DATE('2023-05-05', 'YYYY-MM-DD'), 'Tipo2', 4, 'Comprimidos', 'Observação5', 5, 1),
    ('Medicamento6', TO_DATE('2023-06-06', 'YYYY-MM-DD'), 'Tipo1', 2, 'Cápsulas', 'Observação6', 2, 2),
    ('Medicamento7', TO_DATE('2023-07-07', 'YYYY-MM-DD'), 'Tipo3', 3, 'Injeções', 'Observação7', 3, 3),
    ('Medicamento8', TO_DATE('2023-08-08', 'YYYY-MM-DD'), 'Tipo2', 1, 'Frascos', 'Observação8', 4, 4),
    ('Medicamento9', TO_DATE('2023-09-09', 'YYYY-MM-DD'), 'Tipo1', 4, 'Comprimidos', 'Observação9', 5, 1),
    ('Medicamento10', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 'Tipo3', 2, 'Cápsulas', 'Observação10', 2, 2);

