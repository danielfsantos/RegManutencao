INSERT INTO PLATAFORMA (NOME) VALUES ('XBOX ONE')
INSERT INTO JOGOS (NOME,FKIDGENERO,FKIDPLATAFORMA) VALUES ('THE CREW',3,4)
INSERT INTO GENERO (NOME)VALUES ('CORRIDA');

#TESTES DOS INSERTS
SELECT * FROM PLATAFORMA
SELECT * FROM GENERO
SELECT * FROM JOGOS

SELECT A.NOME , B.NOME,C.NOME FROM JOGOS A 
INNER JOIN GENERO B ON A.FKIDGENERO = B.IDGENERO 
INNER JOIN PLATAFORMA C ON A.FKIDPLATAFORMA = C.IDPLATAFORMA

DELETE FROM JOGOS WHERE IDJOGO= 9
