# 🧠 Mental Health API — Global Solution 2025  
Plataforma de Monitoramento de Bem-Estar e Saúde Mental  
**Curso:** Engenharia de Software – 2ESPH  
**Disciplina:** Domain Driven Design – Java  

---

## Integrantes:

Djalma Moreira de Andrade Filho - RM: 555530

Felipe Paes de Barros Muller Carioba - RM: 558447

Jose Antonio Kretzer Rodriguez - RM: 555523

---

## 📝 1. Descrição do Projeto

A saúde mental se tornou um dos principais desafios da modernidade. Com o aumento de casos de ansiedade e estresse, soluções tecnológicas surgem como apoio essencial.

A **Mental Health API** é uma API REST para:

- Gerenciar **Pacientes**
- Registrar **humor, ansiedade e horas de sono**
- Consultar e atualizar registros diários

O projeto faz parte da **Global Solution 2025**, integrando a ODS 3 — Saúde e Bem-Estar.

---

## 🎯 2. Objetivo da Solução

Criar uma solução backend simples, funcional e extensível que permita monitorar indicadores de bem-estar emocional ao longo do tempo.

---

## ⚙️ 3. Tecnologias Utilizadas

- Java 17  
- Spring Boot 4  
- Spring Web  
- Spring Data JPA  
- Lombok  
- Banco H2 (em memória)  
- Maven  

---

## 🧱 4. Arquitetura do Projeto

```
src/main/java/com.gs2025.mentalhealth/
│
├── controller/        → Endpoints REST
├── service/           → Regras de negócio
├── repository/        → Persistência (JPA)
├── dto/               → Transfer Objects
├── mapper/            → Conversão DTO ↔ Model
└── entity/            → Paciente e RegistroDiario

```

Configurações:

- JDBC URL → `jdbc:h2:mem:mentaldb`
- User → `sa`
- Password → *(vazio)*

---

## ▶️ 5. Como Executar

### Pré-requisitos

- Java 17+
- Maven instalado
- Postman / Insomnia
- Editor de código

### Executar no terminal

```bash
mvn clean install
mvn spring-boot:run
```

API disponível em:

```
http://localhost:9090
```

---

# 📌 6. ENDPOINTS — Postman / Insomnia

A seguir, todos os endpoints com **exemplos que você pode copiar e colar no Postman**.

---

# 👤 PACIENTES

## ➕ Criar Paciente  
**POST**  
```
http://localhost:9090/pacientes
```

### Body (raw JSON)

```json
{
  "nome": "Felipe",
  "email": "felipe@example.com",
  "dataNascimento": "2000-01-01"
}
```

---

## 📄 Listar todos  
**GET**
```
http://localhost:9090/pacientes
```

---

## 🔍 Buscar por ID  
**GET**
```
http://localhost:9090/pacientes/1
```

---

## ✏️ Atualizar Paciente  
**PUT**  
```
http://localhost:9090/pacientes/1
```

### Body (JSON)

```json
{
  "nome": "Felipe Atualizado",
  "email": "felipe.new@example.com",
  "dataNascimento": "2000-01-01"
}
```

---

## ❌ Deletar Paciente  
**DELETE**
```
http://localhost:9090/pacientes/1
```

---

# 📘 REGISTROS DIÁRIOS

## ➕ Criar Registro  
**POST**
```
http://localhost:9090/registros
```

### Body

```json
{
  "dataRegistro": "2025-11-20",
  "nivelHumor": 3,
  "nivelAnsiedade": 2,
  "horasSono": 7,
  "pacienteId": 1
}
```

---

## 📄 Listar Registros  
**GET**
```
http://localhost:9090/registros
```

---

## 🔍 Buscar Registro por ID  
**GET**
```
http://localhost:9090/registros/1
```

---

## ✏️ Atualizar Registro  
**PUT**
```
http://localhost:9090/registros/1
```

### Body

```json
{
  "dataRegistro": "2025-11-21",
  "nivelHumor": 4,
  "nivelAnsiedade": 1,
  "horasSono": 8,
  "pacienteId": 1
}
```

---

## ❌ Deletar Registro  
**DELETE**
```
http://localhost:9090/registros/1
```

---

# ⚠️ 7. Validações

### Paciente
- Nome obrigatório  
- Email válido  
- Data de nascimento não pode ser futura  

### Registro Diário
- Humor: número entre 1 e 5  
- Ansiedade: número entre 1 e 5  
- Data não pode ser futura  
- Registro deve estar vinculado a um paciente  

---

# ❗ 8. Tratamento de Erros

Exemplo de erro padronizado:

```json
{
  "status": 404,
  "mensagem": "Paciente não encontrado",
  "path": "/pacientes/99"
}
```

# 🧩 9. Conclusão

A solução oferece uma API completa para acompanhamento de indicadores emocionais, permitindo expansão futura e integração com dashboards ou aplicativos móveis.

