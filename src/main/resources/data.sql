INSERT INTO PUBLIC.EMPLOYER(ID, FIRST_NAME, LAST_NAME, MATRICULE) VALUES
(1, 'Mohamed', 'Jarray', 'MJA14588'),
(2, 'Alice', 'Johnason', 'AJO45008'),
(3, 'Elisa', 'Quaston', 'EQU162705'),
(4, 'Kevin', 'Bokin', 'KBO145889');

INSERT INTO PUBLIC.TICKET_API(ID, DESCRIPTIF, IS_CLOS, PERIMETRE, TEMPS_TRAITEMENT, TYPE_INTERVENTION) VALUES
(5, 'Probleme lors de la recuperation des PP', TRUE, 'EPR', 0.25, NULL),
(6, STRINGDECODE('Popin bloqante lors de validation de cr\u00e9dit conso'), TRUE, 'CDR', 0.25, 'Aiguillage'),
(7, 'NPE recherche PM', TRUE, 'SRT', 0.5, 'Assistant'),
(8, STRINGDECODE('Erreur de mapping des donne\u00e9s'), TRUE, 'IM', 1.5, 'Analyse');

INSERT INTO PUBLIC.EMPLOYER_TICKET(EMPLOYER_ID, TICKET_ID) VALUES
(4, 6),
(1, 7),
(1, 8);
