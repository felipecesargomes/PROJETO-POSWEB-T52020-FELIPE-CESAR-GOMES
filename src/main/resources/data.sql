DELETE FROM T_PLANO_SAUDE WHERE ID = 1 AND UPPER(NOME) != 'PARTICULAR';
INSERT INTO T_PLANO_SAUDE(ID, NOME) 
SELECT 1, 'PARTICULAR'
WHERE NOT EXISTS (SELECT 1 FROM T_PLANO_SAUDE WHERE ID = 1);

DELETE FROM T_PLANO_SAUDE WHERE ID = 2 AND UPPER(NOME) != 'UNIMED NORMAL';
INSERT INTO T_PLANO_SAUDE(ID, NOME) 
SELECT 2, 'UNIMED NORMAL'
WHERE NOT EXISTS (SELECT 1 FROM T_PLANO_SAUDE WHERE ID = 2);

DELETE FROM T_PLANO_SAUDE WHERE ID = 3 AND UPPER(NOME) != 'UNIMED INTERCAMBIO';
INSERT INTO T_PLANO_SAUDE(ID, NOME) 
SELECT 3, 'UNIMED INTERCAMBIO'
WHERE NOT EXISTS (SELECT 1 FROM T_PLANO_SAUDE WHERE ID = 3);

DELETE FROM T_PLANO_SAUDE WHERE ID = 4 AND UPPER(NOME) != 'BRADESCO CONVENIO';
INSERT INTO T_PLANO_SAUDE(ID, NOME) 
SELECT 4, 'BRADESCO CONVENIO'
WHERE NOT EXISTS (SELECT 1 FROM T_PLANO_SAUDE WHERE ID = 4);


DELETE FROM T_ALIMENTOS WHERE ID = 1 AND UPPER(NOME_ALIMENTO) != 'BANANA';
INSERT INTO T_ALIMENTOS(ID, NOME_ALIMENTO,KCAL,CARB,PROT,GORD_TOTAIS,VITAMINAA,VITAMINAB,VITAMINAC,CALCIO,FERRO) 
SELECT 1,'BANANA',104.0, 26, 1.3, 0.1, 0, 0, 21.6, 7.6, 0.4
WHERE NOT EXISTS (SELECT 1 FROM T_ALIMENTOS WHERE ID = 1);

DELETE FROM T_ALIMENTOS WHERE ID = 2 AND UPPER(NOME_ALIMENTO) != 'AVEIA FLOCOS FINO QUAKER';
INSERT INTO T_ALIMENTOS(ID, NOME_ALIMENTO,KCAL,CARB,PROT,GORD_TOTAIS,VITAMINAA,VITAMINAB,VITAMINAC,CALCIO,FERRO) 
SELECT 2,'AVEIA FLOCOS FINO QUAKER',39.96, 9.99, 2.09, 0.1, 0, 0, 0, 0, 0
WHERE NOT EXISTS (SELECT 1 FROM T_ALIMENTOS WHERE ID = 2);