/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.algoritmogenetico;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.Dia;
import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import co.edu.ucc.semillero.generadorhorarios.modelo.Salon;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;

/**
 *
 * @author Eduardo
 */
public class Individuo {

    private int valorFitness;
    private Long[] genes;
    private int genesSize;

    
    /**
     *
     */
    public Individuo(){
        
    }
    
    public Individuo(int genesSize){
        this.genes = new Long[genesSize];
    }

    /**
     *
     * @return
     */
    public int getValorFitness() {
        return valorFitness;
    }

    /**
     *
     * @param valorFitness
     */
    public void setValorFitness(int valorFitness) {
        this.valorFitness = valorFitness;
    }

    /**
     *
     * @param index
     * @return
     */
    public Long getGene(int index) {
        return genes[index];
    }

    /**
     *
     * @param index
     * @param gene
     */
    public void setGene(int index, Long gene) {
        this.genes[index] = gene;
    }

    /**
     *
     * @return
     */
    public int getGenesSize() {
        return genes.length;
    }

    public void setGenesSize(int genesSize) {
        this.genesSize = genesSize;
    }
    
    
    /**
     *
     */
    public void genesAleatorios(List<DetalleHorario> detalleHorarios, List<Dia> dias, List<Hora> horas, List<Salon> salones) { // pobla la cadena de genes con los valores que componen el individuo.
        int genActual = 0;
        Random randDia = new Random();
        Random randHora = new Random();
        Random randSalon = new Random();

        genes = new Long[detalleHorarios.size() * 9];

        for (int i = 0; i < detalleHorarios.size(); ++i) {
            genes[genActual] = dias.get(randDia.nextInt(dias.size())).getId();
            //System.out.println("i: "+i+", Dia: "+genes[genActual]);
            genActual++;
            genes[genActual] = horas.get(randHora.nextInt(horas.size())).getId();
            //System.out.println("i: "+i+", Hora: "+genes[genActual]);
            genActual++;
            genes[genActual] = salones.get(randSalon.nextInt(salones.size())).getId();
            //System.out.println("i: "+i+", Salon: "+genes[genActual]);
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getDocente().getId();
            //System.out.println("i: "+i+", Docente: "+genes[genActual]);
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getMateria().getId();
            //System.out.println("i: "+i+", Materia: "+genes[genActual]);
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getSemestre().getId();
            //System.out.println("i: "+i+", Semestre: "+genes[genActual]);
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getFacultad().getId();
            //System.out.println("i: "+i+", Facultad: "+genes[genActual]);
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getParalelo().getId();
            //System.out.println("i: "+i+", Paralelo: "+genes[genActual]);
            genActual++;
            genes[genActual] = Long.parseLong("" + detalleHorarios.get(i).getSesion());
            //System.out.println("i: "+i+", Sesion: "+genes[genActual]);
            genActual++;
        }
    }

    /**
     *
     */
    public void mutacion(List<DetalleHorario> detalleHorarios, List<Dia> dias, List<Hora> horas, List<Salon> salones) { // Selecciona una seccion de genes aleatoriamente y cambia dia, hora y salon asignados.
        Random randGen = new Random();
        Random randDia = new Random();
        Random randHora = new Random();
        Random randSalon = new Random();
        System.out.println("detalleHorarios.size(): " + detalleHorarios.size());
        int i = randGen.nextInt(detalleHorarios.size());
        i *= 8;
        genes[i] = dias.get(randDia.nextInt(dias.size())).getId();
        i++;
        genes[i] = horas.get(randHora.nextInt(horas.size())).getId();
        i++;
        genes[i] = salones.get(randSalon.nextInt(salones.size())).getId();
    }

    /**
     *
     * @return
     */
    public int evaluar() { // Pendiente
        Random randFitness = new Random();
        valorFitness = randFitness.nextInt(100);
        return valorFitness;
        // Consultar lista de variables
        /*List paralelo = new ArrayList();
         List periodo = new ArrayList();
         List sesion = new ArrayList();
         List profesor = new ArrayList();
         List materia = new ArrayList();
         List tipoAula = new ArrayList();
         List disponibilidad = new ArrayList();

         Integer[][][] hParaleloPeriodoSesion = new Integer[paralelo.size()][periodo.size()][sesion.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < paralelo.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < periodo.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         for (int l = 0; l < sesion.size(); l++) {
         if (sesion.get(l) == detalleHorarios.get(i).getDia()) {
         hParaleloPeriodoSesion[j][k][l] = 1;
         }
         }
         }
         }
         }
         }
         }

         Integer[][][] pProfesorParaleloSesion = new Integer[profesor.size()][paralelo.size()][sesion.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < profesor.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < paralelo.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         for (int l = 0; l < sesion.size(); l++) {
         if (sesion.get(l) == detalleHorarios.get(i).getDia()) {
         pProfesorParaleloSesion[j][k][l] = 1;
         }
         }
         }
         }
         }
         }
         }

         Integer[][] mMateriaSesion = new Integer[materia.size()][sesion.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < materia.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < sesion.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         mMateriaSesion[j][k] = 1;

         }
         }
         }
         }
         }

         Integer[][] gParaleloSesion = new Integer[paralelo.size()][sesion.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < paralelo.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < sesion.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         gParaleloSesion[j][k] = 1;

         }
         }
         }
         }
         }

         Integer[] aCantidadAulasTipo = new Integer[tipoAula.size()];
         for (int i = 0; i < tipoAula.size(); i++) {

         }

         Integer[][][] tMateriaParaleloTipoAula = new Integer[materia.size()][paralelo.size()][tipoAula.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < materia.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < paralelo.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         for (int l = 0; l < tipoAula.size(); l++) {
         if (sesion.get(l) == detalleHorarios.get(i).getDia()) {
         tMateriaParaleloTipoAula[j][k][l] = 1;
         }
         }
         }
         }
         }
         }
         }

         Integer[] lDuracionSesion = new Integer[sesion.size()];
         for (int i = 0; i < sesion.size(); i++) {

         }

         Integer[][] dPeriodoDia = new Integer[periodo.size()][dias.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < periodo.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < dias.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         dPeriodoDia[j][k] = 1;

         }
         }
         }
         }
         }

         Integer[][] ePeriodoHora = new Integer[periodo.size()][horas.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < periodo.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < horas.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         ePeriodoHora[j][k] = 1;

         }
         }
         }
         }
         }

         Integer[] bNivelPreferenciaDocente = new Integer[0];

         Integer[][][] sProfesorPeriodoDisponibilidad = new Integer[profesor.size()][periodo.size()][disponibilidad.size()];
         for (int i = 0; i < detalleHorarios.size(); i++) {
         for (int j = 0; j < profesor.size(); j++) {
         if (paralelo.get(j) == detalleHorarios.get(i).getDia()) {
         for (int k = 0; k < periodo.size(); k++) {
         if (periodo.get(k) == detalleHorarios.get(i).getDia()) {
         for (int l = 0; l < disponibilidad.size(); l++) {
         if (sesion.get(l) == detalleHorarios.get(i).getDia()) {
         sProfesorPeriodoDisponibilidad[j][k][l] = 1;
         }
         }
         }
         }
         }
         }
         }

         //cruce de profesores
         int cruceProfesores = 0;
         for (int i = 0; i < profesor.size(); i++) {
         for (int l = 0; l < periodo.size(); l++) {
         for (int j = 0; j < paralelo.size(); j++) {
         for (int k = 0; k < sesion.size(); k++) {
         if (pProfesorParaleloSesion[i][j][k] == 1 && hParaleloPeriodoSesion[j][l][k] == 1) {
         cruceProfesores++;
         }
         }
         }
         }
         }

         return 0;*/
    }

}
