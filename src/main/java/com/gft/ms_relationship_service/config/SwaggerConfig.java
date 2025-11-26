package com.gft.ms_relationship_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("WordTagRelationship API")
                        .version("1.0.0")
                        .description("""
                            Serviço responsável pela gestão de Etiquetas em uma arquitetura de microserviços.
                            
                                    Este serviço tem como responsabilidades principais:
                                    - Gerenciar o cadastro de Etiquetas (CRUD);
                                    - Validar a existência de uma Etiqueta para o Relationship-Service;
                                    - Expor dados básicos para outros microsserviços de forma segura e padronizada;
                                    - Fornecer endpoint para consulta de Palavras associadas (via comunicação síncrona com o Relationship-Service).
                            
                                    Este serviço **não** conhece regras de negócio de palavras e nem armazena relacionamentos.
                                    Seu objetivo é manter apenas o estado da Etiqueta.
                            """)
                        .contact(new Contact()
                                .name("Daniel Nascimento")
                                .email("Daniel.Tomaz@gft.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )

                .servers(List.of(
                                new Server()
                                        .url("http://localhost:8080")
                                        .description("Servidor local de desenvolvimento")
                        )
                );


    }
}
