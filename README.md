"# Event-Driven-Micro-Services-Architectures-with-CQRS-and-Event-Sourcing-AXON-and-Spring-Cloud" 

Event Driven Micro Services Architecture, CQRS and Event Sourcing Patterns: Axon Framework and Spring Cloud

[FR] Français
[EN] English

 [FR] 
 *************************************************************************************************************************************************************************
 
 PATTERN EVENT SOURCING

-> Capturer tous les changements de l'état de l'application comme séquences d'évènements.

-> Ne pas se concentrer sur l'état courant de l'application, mais sur la séquence de changements d'états (évènements metiers) qui ont abouti à l'état courant.

-> A partir de cet évènement on pourra agréger l'état courant de l'application.

-> Tout changement de l'état de l'application a une cause unique (évènement).

-> Exemple: opérations éffectuées sur un compte bancaire.

AVANTAGE EVENT SOURCING

-> Base d'audit

-> Analyse de debug : Retrouver facilement l'origine des bugs en prods

-> Reprise de données: En cas de panne, réjouer tous les évènements metiers enregistrés pour retrouver l'état de l'application

-> Performances : Asynchrone avec des Bus de méssage qui se mettent bien à l'échelle (Scalabilité)

-> A partir des évènement on peut créer plusieurs projections avec des modèles de données differentes

CQRS COMMAND QUERY RESPONSABILITY SEGREGATION

C'est un pattern qui consiste à separer la partie lecture de la partie écriture d'une application.

-> Command: une intention externe de modification de l'état d'un objet (insert, update, delete)

-> Query: une intention de consultation d'une information ou de l'état d'un objet (select)

-> Event: symbolise une action qui s'est produite dans le système.

-> Event Bus: un mécanisme qui permet de dispatcher les évènements vers les écouteurs d'évènement(Event Handler) par exemple KAFKA ou RabbitMQ

-> Event Store: Base de persistance des évènements publiés dans l'application

AVANTAGE CQRS

-> On peut agreger facilement les données de plusieurs micro services

-> Mise à l'échèlle séparement des deux parties Lecture (90%) écriture (10%)

-> Liberter de choisir des SGBD différents pour la lecture et l'écriture

-> Faciliter la séparation des aspect d'écriture et de lecture

-> Faciliter la separation des deux modeles pour le lecture et l'écriture.




[EN] 
**********************************************************************************************************************************************************

PATTERN EVENT SOURCING

-> Capture all changes in the state of the application as sequences of events.

-> Do not focus on the current state of the application, but on the sequence of state changes (business events) which resulted in the current state.

-> From this event we can aggregate the current state of the application.

-> Any change in the state of the application has a single cause (event).

-> Example: transactions carried out on a bank account.

ADVANTAGE EVENT SOURCING

-> Audit base

-> Debug analysis: Easily find the origin of bugs in prods

-> Data recovery: In the event of a failure, replay all the business events recorded to find the application status

-> Performance: Asynchronous with Message Buses that scale well (Scalability)

->From the events we can create several projections with different data models

CQRS COMMAND QUERY RESPONSABILITY SEGREGATION

It is a pattern which consists in separating the reading part from the writing part of an application.

-> Command: an external intention to modify the state of an object (insert, update, delete)

-> Query: an intention to consult information or the state of an object (select)

-> Event: symbolizes an action that has occurred in the system.

-> Event Bus: a mechanism that allows events to be dispatched to event listeners (Event Handler), for example KAFKA or RabbitMQ

ADVANTAGE CQRS

-> We can easily aggregate the data of several micro services

-> Scaling the two parts separately Read (90%) Write (10%)

-> Free to choose different DBMS for reading and writing

-> Facilitate the separation of writing and reading aspects

-> Facilitate the separation of the two models for reading and writing











