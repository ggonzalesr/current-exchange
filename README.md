# current-exchange
Una API reactiva para consultar y actualizar tasas de cambio, con autenticación JWT y registro de auditoría.

Características principales: 
-Arquitectura reactiva con Spring WebFlux
-Autenticación JWT para acceso seguro
-Registro de auditoría de todas las operaciones
-Conversión de divisas en tiempo real
-Manejo de errores personalizado

Tecnologías utilizadas:
-Java 17
-Spring Boot 3.x
-Spring WebFlux
-Spring Security
-JWT (JSON Web Tokens)
-R2DBC (Reactive Database Connectivity)
-H2 Database (para desarrollo)

Requisitos previos:
-JDK 17 instalado
-Maven instalado
-Postman o similar para probar los endpoints

USO:

Autenticación
1) Obtener token JWT:
 POST /api/auth/login
 Body: {"username":"admin", "XXXXX":"admin"}
 
Endpoints Disponibles:
1) Conversión de divisas:
  POST /api/exchange/convert
  Headers: Authorization: Bearer <token>
  Body: {
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "amount": 100
  }
  
Extructura del Proyecto:

exchange-rate-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/exchangerate/
│   │   │   ├── config/          # Configuraciones
│   │   │   ├── controller/      # Controladores
│   │   │   ├── dto/             # Objetos de transferencia
│   │   │   ├── exception/       # Manejo de errores
│   │   │   ├── model/           # Entidades
│   │   │   ├── repository/      # Repositorios reactivos
│   │   │   ├── security/        # Configuración de seguridad
│   │   │   ├── service/         # Lógica de negocio
│   │   │   └── ExchangeRateApplication.java
│   │   └── resources/           # Configuración y datos iniciales
├── .gitignore
├── pom.xml
└── README.md