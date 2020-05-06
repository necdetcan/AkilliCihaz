--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: Kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanici" (
    "kullaniciAdi" character varying(2044) NOT NULL,
    sifre character varying(2044) NOT NULL,
    yetki character varying(2044)
);


ALTER TABLE public."Kullanici" OWNER TO postgres;

--
-- Data for Name: Kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanici" VALUES ('kullanici1', '1234', 'sicaklik goruntuleme');
INSERT INTO public."Kullanici" VALUES ('kullanici2', '12345', 'sicaklik goruntuleme sogutucu acma sogutucu kapatma');
INSERT INTO public."Kullanici" VALUES ('kullanici3', '123456', 'sicaklik goruntuleme sogutucu acma sogutucu kapatma');


--
-- Name: Kullanici unique_Kullanici_kullaniciAdi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "unique_Kullanici_kullaniciAdi" PRIMARY KEY ("kullaniciAdi");


--
-- PostgreSQL database dump complete
--

