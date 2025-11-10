-- INVERNADA
create table if not exists invernada (
                                         id bigserial primary key,
                                         descricao varchar(120) not null,
    url_foto text,
    observacoes text
    );

-- BOVINO
create table if not exists bovino (
                                      id bigserial primary key,
                                      nome_animal varchar(120) not null,
    codigo_epc varchar(64) not null unique,
    codigo_interno varchar(64),
    numero_brinco varchar(64),
    raca varchar(80),
    data_nascimento date,
    peso_atual_kg numeric(10,2),
    pelagem varchar(60),
    invernada_id bigint not null references invernada(id)
    );

-- LEITURA RFID
create table if not exists leitura_rfid (
                                            id bigserial primary key,
                                            antena varchar(60),
    timestamp timestamp,
    bovino_id bigint not null references bovino(id)
    );

-- EVENTO SANITARIO
create table if not exists evento_sanitario (
                                                id bigserial primary key,
                                                tipo varchar(40) not null,
    descricao text,
    data_evento date,
    bovino_id bigint not null references bovino(id)
    );
