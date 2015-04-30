/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.*;
import co.edu.ucc.semillero.generadorhorarios.servicios.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Eduardo
 */
@ManagedBean(name = "mbImportarDatos")
@ViewScoped
public class ImportarDatos implements Serializable {

    @EJB
    private LogicaBloque logicaBloque;
    @EJB
    private LogicaDetalleHorario logicaDetalleHorario;
    @EJB
    private LogicaDia logicaDia;
    @EJB
    private LogicaDocente logicaDocente;
    @EJB
    private LogicaFacultad logicaFacultad;
    @EJB
    private LogicaHora logicaHora;
    @EJB
    private LogicaHorarioLaborable logicaHorarioLaborable;
    @EJB
    private LogicaMateria logicaMateria;
    @EJB
    private LogicaParalelo logicaParalelo;
    @EJB
    private LogicaSalon logicaSalon;
    @EJB
    private LogicaSalonTipo logicaSalonTipo;
    @EJB
    private LogicaSemestre logicaSemestre;

    List<Docente> listaDocentes;
    List<Materia> listaMaterias;
    List<Semestre> listaSemestres;
    List<Facultad> listaFacultades;
    List<Paralelo> listaParalelos;
    List<Dia> listaDia;
    List<Hora> listaHora;
    List<Bloque> listaBloques;
    List<SalonTipo> listaSalonTipos;

    /**
     *
     * @param args
     */
    public String importar() {

        File file = new File("c:/datos.txt");

        try {

            List<String> contents = FileUtils.readLines(file);

            for (String line : contents) {

                int auxInicial;
                int auxFinal;
                String string;

                switch (line.substring(0, 1)) {
                    case "1":
                        Bloque bloque = new Bloque();
                        bloque.setNombre(line.substring(4, line.length() - 1));
                        logicaBloque.guardar(bloque);
                        break;
                    case "2":
                        DetalleHorario detalleHorario = new DetalleHorario();

                        listaDocentes = logicaDocente.consultarDocentes();
                        listaMaterias = logicaMateria.consultarMaterias();
                        listaSemestres = logicaSemestre.consultarSemestres();
                        listaFacultades = logicaFacultad.consultarFacultads();
                        listaParalelos = logicaParalelo.consultarParalelos();

                        auxFinal = line.indexOf(" ", 16);
                        String string1 = line.substring(16, auxFinal);
                        System.out.println("Nombre: " + string1);
                        auxInicial = auxFinal;
                        System.out.println("auxI: " + auxInicial);
                        auxFinal = line.indexOf(",", auxInicial);
                        System.out.println("auxF: " + auxFinal);
                        String string2 = line.substring(auxInicial + 1, auxFinal - 1);
                        System.out.println("Apellido: " + string2);
                        for (Docente docenteDetelleHorario : listaDocentes) {
                            if (docenteDetelleHorario.getNombre().matches(string1) && docenteDetelleHorario.getApellido().matches(string2)) {
                                detalleHorario.setDocente(docenteDetelleHorario);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Materia materiaDetelleHorario : listaMaterias) {
                            if (materiaDetelleHorario.getNombre().matches(string)) {
                                detalleHorario.setMateria(materiaDetelleHorario);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Semestre semestreDetelleHorario : listaSemestres) {
                            if (semestreDetelleHorario.getNombre().matches(string)) {
                                detalleHorario.setSemestre(semestreDetelleHorario);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Facultad facultadDetelleHorario : listaFacultades) {
                            if (facultadDetelleHorario.getNombre().matches(string)) {
                                detalleHorario.setFacultad(facultadDetelleHorario);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Paralelo paraleloDetelleHorario : listaParalelos) {
                            if (paraleloDetelleHorario.getNombre().matches(string)) {
                                detalleHorario.setParalelo(paraleloDetelleHorario);
                            }
                        }
                        auxInicial = auxFinal + 6;
                        detalleHorario.setSesion(Integer.parseInt(line.substring(auxInicial, line.length())));

                        logicaDetalleHorario.guardar(detalleHorario);

                        break;
                    case "3":
                        Dia dia = new Dia();
                        dia.setNombre(line.substring(4, line.length() - 1));
                        logicaDia.guardar(dia);
                        break;
                    case "4":
                        Docente docente = new Docente();

                        auxFinal = line.indexOf(",", 4);
                        docente.setNombre(line.substring(4, auxFinal - 1));
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        docente.setApellido(line.substring(auxInicial + 1, auxFinal - 1));
                        auxInicial = auxFinal + 2;
                        docente.setCedula(Integer.parseInt(line.substring(auxInicial, line.length())));
                        logicaDocente.guardar(docente);
                        break;
                    case "5":
                        Facultad facultad = new Facultad();
                        facultad.setNombre(line.substring(4, line.length() - 1));
                        logicaFacultad.guardar(facultad);
                        break;
                    case "6":
                        Hora hora = new Hora();
                        hora.setNombre(line.substring(4, line.length() - 1));
                        hora.setIntervalo(line.substring(4, line.length() - 1));
                        logicaHora.guardar(hora);
                        break;
                    case "7":
                        break;
                    case "8":
                        HorarioLaborable horarioLaborable = new HorarioLaborable();

                        listaDia = logicaDia.consultarDias();
                        listaHora = logicaHora.consultarHoras();

                        auxFinal = line.indexOf(",", 4);
                        string = line.substring(4, auxFinal - 1);
                        for (Dia diaHorarioLaborable : listaDia) {
                            if (diaHorarioLaborable.getNombre().matches(string)) {
                                horarioLaborable.setDia(diaHorarioLaborable);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        string = line.substring(auxInicial + 1, line.length() - 1);
                        for (Hora horaHorarioLaborable : listaHora) {
                            if (horaHorarioLaborable.getNombre().matches(string)) {
                                horarioLaborable.setHora(horaHorarioLaborable);
                            }
                        }

                        logicaHorarioLaborable.guardar(horarioLaborable);
                        break;
                    case "9":
                        Materia materia = new Materia();
                        auxFinal = line.indexOf(",", 4);
                        materia.setNombre(line.substring(4, auxFinal - 1));
                        auxInicial = auxFinal + 2;
                        materia.setHorasPresenciales(Integer.parseInt(line.substring(auxInicial, line.length())));
                        logicaMateria.guardar(materia);
                        break;
                    case "a":
                        Paralelo paralelo = new Paralelo();

                        listaSemestres = logicaSemestre.consultarSemestres();
                        listaFacultades = logicaFacultad.consultarFacultads();

                        auxFinal = line.indexOf(",", 4);
                        paralelo.setNombre(line.substring(4, auxFinal - 1));
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Semestre semestreParalelo : listaSemestres) {
                            if (semestreParalelo.getNombre().matches(string)) {
                                paralelo.setSemestre(semestreParalelo);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        string = line.substring(auxInicial + 1, line.length() - 1);
                        for (Facultad facultadParalelo : listaFacultades) {
                            if (facultadParalelo.getNombre().matches(string)) {
                                paralelo.setFacultad(facultadParalelo);
                            }
                        }

                        logicaParalelo.guardar(paralelo);
                        break;
                    case "b":
                        break;
                    case "c":
                        Salon salon = new Salon();

                        listaBloques = logicaBloque.consultarBloques();
                        listaSalonTipos = logicaSalonTipo.consultarSalonTipos();

                        auxFinal = line.indexOf(",", 4);
                        salon.setNombre(line.substring(4, auxFinal - 1));
                        auxInicial = auxFinal + 2;
                        auxFinal = line.indexOf(",", auxInicial);
                        string = line.substring(auxInicial + 1, auxFinal - 1);
                        for (Bloque bloqueSalon : listaBloques) {
                            if (bloqueSalon.getNombre().matches(string)) {
                                salon.setBloque(bloqueSalon);
                            }
                        }
                        auxInicial = auxFinal + 2;
                        string = line.substring(auxInicial + 1, line.length() - 1);
                        for (SalonTipo salonTipoSalon : listaSalonTipos) {
                            if (salonTipoSalon.getNombre().matches(string)) {
                                salon.setSalonTipo(salonTipoSalon);
                            }
                        }

                        logicaSalon.guardar(salon);
                        break;
                    case "d":
                        SalonTipo salonTipo = new SalonTipo();
                        salonTipo.setNombre(line.substring(4, line.length() - 1));
                        logicaSalonTipo.guardar(salonTipo);
                        break;
                    case "e":
                        Semestre semestre = new Semestre();
                        semestre.setNombre(line.substring(4, line.length() - 1));
                        logicaSemestre.guardar(semestre);
                        break;
                    default:
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
