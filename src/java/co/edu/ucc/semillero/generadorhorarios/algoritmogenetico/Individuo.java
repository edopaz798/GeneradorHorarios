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

/**
 * Clase que representa el funcionamiento de los Individuos
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
public class Individuo {

    private int valorFitness;
    private Long[] genes;
    private int genesSize;

    /**
     * Metodo constructor que obtiene como parametro la cantidad de genes que va
     * a contener este individuo y lo asigna a las variables de clase, ademas
     * instancia la cadena que los va a contener con este mismo tamaño
     *
     * @param genesSize variable de tipo int que contiene la cantidad de genes
     * para este individuo
     * @since 1.0.0
     */
    public Individuo(int genesSize) {
        this.genesSize = genesSize;
        this.genes = new Long[genesSize];
    }

    /**
     * Constructor vacio para la generacion de un nuevo individuo
     *
     * @since 1.0.0
     */
    public Individuo() {

    }

    /**
     ** Metodo para obtener el valor actual de la variable valorFitness que es
     * de tipo int
     *
     * @return retorna la variable valorFitness
     * @since 1.0.0
     */
    public int getValorFitness() {
        return valorFitness;
    }

    /**
     * Metodo para guardar los valores de tipo int en la variable valorFitness.
     *
     * @param valorFitness int a guardar
     * @since 1.0.0
     */
    public void setValorFitness(int valorFitness) {
        this.valorFitness = valorFitness;
    }

    /**
     * Metodo para obtener un gen especifico de este individuo
     *
     * @param i variable de tipo int que indica el indice del gen a buscar
     * @return retorna el gen que ha sido indicado por la variable i
     * @since 1.0.0
     */
    public Long getGene(int i) {
        return genes[i];
    }

    /**
     * Metodo para guardar un gen nuevo en una ubicacion determinada por la
     * variable i
     *
     * @param i variable de tipo int que indica la poscione donde sera guardado
     * el gen nuevo
     * @param gen variable de tipo Long que indica el valor del nuevo gen que se
     * va a guardar
     * @since 1.0.0
     */
    public void setGene(int i, Long gen) {
        this.genes[i] = gen;
    }

    /**
     * Metodo para obtner el tamaño actual de la cadena de genes
     *
     * @return retorna un int con el tamaño del array genes
     * @since 1.0.0
     */
    public int getGenesSize() {
        return genes.length;
    }

    /**
     * Metodo para guardar el valor de la variable genesSize que es de tipo
     * entero
     *
     * @param genesSize valor asignado a la variable de clase genesSize de tipo
     * entero
     * @since 1.0.0
     */
    public void setGenesSize(int genesSize) {
        this.genesSize = genesSize;
    }

    /**
     * Metodo que se encarga de la generacion aleatorio de los genes para las
     * variables de dia, hora y salon, usando generadores de numeros aleatorios
     *
     * @param detalleHorarios variable de tipo List(DetalleHorario) que contiene
     * todas las ocurrencies de tipo DetalleHorario dentro de la base de datos
     * @param dias variable de tipo List(Dia) que contiene todas las ocurrencies
     * de tipo Dia dentro de la base de datos
     * @param horas variable de tipo List(Hora) que contiene todas las
     * ocurrencies de tipo Hora dentro de la base de datos
     * @param salones variable de tipo List(Salon) que contiene todas las
     * ocurrencies de tipo Salon dentro de la base de datos
     * @since 1.0.0
     */
    public void genesAleatorios(List<DetalleHorario> detalleHorarios, List<Dia> dias, List<Hora> horas, List<Salon> salones) { // pobla la cadena de genes con los valores que componen el individuo.
        int genActual = 0;
        Random randDia = new Random();
        Random randHora = new Random();
        Random randSalon = new Random();

        genes = new Long[detalleHorarios.size() * 9];

        for (int i = 0; i < detalleHorarios.size(); ++i) {
            genes[genActual] = dias.get(randDia.nextInt(dias.size())).getId();
            genActual++;
            genes[genActual] = horas.get(randHora.nextInt(horas.size())).getId();
            genActual++;
            genes[genActual] = salones.get(randSalon.nextInt(salones.size())).getId();
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getDocente().getId();
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getMateria().getId();
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getSemestre().getId();
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getFacultad().getId();
            genActual++;
            genes[genActual] = detalleHorarios.get(i).getParalelo().getId();
            genActual++;
            genes[genActual] = Long.parseLong("" + detalleHorarios.get(i).getSesion());
            genActual++;
        }
    }

    /**
     * Metodo que se encarga de mutar aleatoriamente los genes de Dia, Hora y
     * Salon de un individuo para generar un nuevo individuo con una carga
     * genetica totalmente nueva en estos tres genes
     *
     * @param detalleHorarios variable de tipo List(DetalleHorario) que contiene
     * todas las ocurrencies de tipo DetalleHorario dentro de la base de datos
     * @param dias variable de tipo List(Dia) que contiene todas las ocurrencies
     * de tipo Dia dentro de la base de datos
     * @param horas variable de tipo List(Hora) que contiene todas las
     * ocurrencies de tipo Hora dentro de la base de datos
     * @param salones variable de tipo List(Salon) que contiene todas las
     * ocurrencies de tipo Salon dentro de la base de datos
     * @since 1.0.0
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
     * Metodo encargado de evaluar el individuo con respecto al modelo
     * matematico establecido, entre menor sea el valor resultante de este
     * metodo, mejor sera el individuo como posible solucion
     *
     * @return retorna la variable valorFitness con la calificacion de este
     * individuo
     * @since 1.0.0
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
