/* Serial = inteiro e autoincrement */
CREATE TABLE IF NOT EXISTS pet (
    cd_Pet serial PRIMARY KEY, 
    nm_Pet varchar(50),
    nm_Especie varchar(20),
    qt_Peso decimal(4,2),
    nm_Tutor varchar(50),
    cd_CpfTutor varchar(11)
);
        -- comando magico: ( drop schema public; )