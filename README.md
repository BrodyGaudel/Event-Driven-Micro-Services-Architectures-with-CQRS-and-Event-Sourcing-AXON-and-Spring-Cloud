"# Event-Driven-Micro-Services-Architectures-with-CQRS-and-Event-Sourcing-AXON-and-Spring-Cloud" 

Event Driven Micro Services Architecture, CQRS and Event Sourcing Patterns: Axon Framework and Spring Cloud

Définition Pattern Event Sourcing [FR] ***********************************************************************************************************************
-> Capturer tous les changements de l'état de l'application comme séquences d'évènements.
-> Ne pas se concentrer sur l'état courant de l'application, mais sur la séquence de changements d'états (évènements metiers) qui ont abouti à l'état courant.
-> A partir de cet évènement on pourra agréger l'état courant de l'application.
-> Tout changement de l'état de l'application a une cause unique (évènement).
-> Exemple: opérations éffectuées sur un compte bancaire.
Avantage 
-> Base d'audit
-> Analyse de debug : Retrouver facilement l'origine des bugs en prods
-> Reprise de données: En cas de panne, réjouer tous les évènements metiers enregistrés pour retrouver l'état de l'application
-> Performances : Asynchrone avec des Bus de méssage qui se mettent bien à l'échelle (Scalabilité)
-> A partir des évènement on peut créer plusieurs projections avec des modèles de données differentes

-> Definition Pattern Event Sourcing [EN] ***********************************************************************************************************************
-> Capture all changes in the state of the application as sequences of events.
-> Do not focus on the current state of the application, but on the sequence of state changes (business events) which resulted in the current state.
-> From this event we can aggregate the current state of the application.
-> Any change in the state of the application has a single cause (event).
-> Example: transactions carried out on a bank account.
Advantage
-> Audit base
-> Debug analysis: Easily find the origin of bugs in prods
-> Data recovery: In the event of a failure, replay all the business events recorded to find the application status
-> Performance: Asynchronous with Message Buses that scale well (Scalability)
->From the events we can create several projections with different data models






