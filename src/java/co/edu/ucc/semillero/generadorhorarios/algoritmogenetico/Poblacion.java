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
 * Clase que representa el funcionamiento de la poblacion.
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
public class Poblacion {

    private final int TAMANO_POBLACION;

    private static final Random random = new Random();
    private final Individuo[] poblacion;
    private double fitnessTotal;

    /**
     * Metodo Constructor para una poblacion, se encarga de dimensionar su
     * tamaño y de generar aleatoriamente la lista de individuos pertenecientes
     * a esta, por medio de los parametros pasados al constriuctor.
     *
     * @param TAMANO_POBLACION Indica el tamaño de la poblacion que se va a
     * generar, es de tipo int
     * @param detalleHorarios Indica la lista con todos los detalleHorarios
     * presentes en la base de datos, es un objeto de tipo List(DetalleHorario)
     * @param dias Indica la lista con todos los dias presentes en la base de
     * datos, es un objeto de tipo List(Dia)
     * @param horas Indica la lista con todas las horas presentes en la base de
     * datos, es un objeto de tipo List(Hora)
     * @param salones Indica la lista con todos los salones presentes en la base
     * de datos, es un objeto de tipo List(Salon)
     * @since 1.0.0
     */
    public Poblacion(int TAMANO_POBLACION, List<DetalleHorario> detalleHorarios, List<Dia> dias, List<Hora> horas, List<Salon> salones) {
        this.TAMANO_POBLACION = TAMANO_POBLACION;

        poblacion = new Individuo[TAMANO_POBLACION];

        for (int i = 0; i < TAMANO_POBLACION; i++) {
            poblacion[i] = new Individuo();
            poblacion[i].genesAleatorios(detalleHorarios, dias, horas, salones);
        }
        this.evaluar();

    }

    /**
     * Metodo para obtener el valor actual de la variable fitnessTotal que es de
     * tipo double
     *
     * @return retorna el valor de la variable fitnessTotal
     * @since 1.0.0
     */
    public double getFitnessTotal() {
        return fitnessTotal;
    }

    /**
     * Metodo para guardar los valores de tipo Individuo en la variable
     * nuevaPoblacion, la cual es un array.
     *
     * @param nuevaPoblacion String a guardar
     * @since 1.0.0
     */
    public void setPoblacion(Individuo[] nuevaPoblacion) {
        System.arraycopy(nuevaPoblacion, 0, this.poblacion, 0, TAMANO_POBLACION);
    }

    /**
     * Metodo para obtener el valor actual de la variable poblacion que es un
     * array de tipo Individuo
     *
     * @return retorna el valor de la variable poblacion
     * @since 1.0.0
     */
    public Individuo[] getPoblacion() {
        return this.poblacion;
    }

    /**
     * Metodo que se encarga de obtener el valor fitness de la poblacion actual,
     * recorre el vector que contiene los individuos pertenecientes a esta y los
     * evalua uno por uno para obtener el valor fitness de esta poblacion.
     *
     * @return retorna la variable fitnessTotal que es de tipo double
     * @since 1.0.0
     */
    public double evaluar() {
        this.fitnessTotal = 0.0;
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            this.fitnessTotal += poblacion[i].evaluar();
        }
        return this.fitnessTotal;
    }

    /**
     * Metodo de la ruleta, que se encarga por medio de un numero aleatorio
     * seleccionar un individuo de la poblacion actual, entre mejor sea su valor
     * fitness mas opciones tiene este de ser seleccionado.
     *
     *
     * @return retorna un individuo de la poblacion
     * @since 1.0.0
     */
    public Individuo ruleta() {
        double numeroRandom;
        numeroRandom = random.nextDouble() * this.fitnessTotal;
        int i;
        for (i = 0; i < TAMANO_POBLACION && numeroRandom > 0; ++i) {
            numeroRandom -= poblacion[i].getValorFitness();
        }
        return poblacion[i - 1];
    }

    /**
     * Metodo que se encarga obtener el mejor individuo de la poblacion actual,
     * este tendra el valor minimo de fitness entre todos los individuos y sera
     * el que mejor se adapte a la solucion
     *
     * @return retorna el individuo con el menor valor de fitness
     * @since 1.0.0
     */
    public Individuo mejorIndividuo() {
        int fitnessMin = 0;
        double maxActual = 0.0;
        double minActual = 1.0;
        double valorActual;

        for (int i = 0; i < TAMANO_POBLACION; ++i) {
            valorActual = poblacion[i].getValorFitness();
            if (maxActual < minActual) {
                maxActual = minActual = valorActual;
                fitnessMin = i;
            }
            if (valorActual > maxActual) {
                maxActual = valorActual;

            }
            if (valorActual < minActual) {
                minActual = valorActual;
                fitnessMin = i;
            }
        }

        return poblacion[fitnessMin];
    }

    /**
     * Metodo que se encarga de realizar el cruze entre los genes de dos
     * individuos diferentes, estos son pasados como parametros, un punto de
     * corte es seleccionado aleatoriamente y luego los genes son intercambiados
     * entre los dos individuos de este punto en adelante, produciendo dos
     * nuevos individuos decendientes de los dos padres con sus genes mezclados
     *
     * @param individuo1
     * @param individuo2
     * @return retorna un array de 2 Individuos
     */
    public Individuo[] cruze(Individuo individuo1, Individuo individuo2) {
        Individuo[] newIndiv = new Individuo[2];
        newIndiv[0] = new Individuo(individuo1.getGenesSize());
        newIndiv[1] = new Individuo(individuo1.getGenesSize());
        int puntoCorte = random.nextInt(newIndiv[0].getGenesSize());
        int i;
        for (i = 0; i < puntoCorte; ++i) {
            newIndiv[0].setGene(i, individuo1.getGene(i));
            newIndiv[1].setGene(i, individuo2.getGene(i));
        }
        for (; i < newIndiv[0].getGenesSize(); ++i) {
            newIndiv[0].setGene(i, individuo2.getGene(i));
            newIndiv[1].setGene(i, individuo1.getGene(i));
        }

        return newIndiv;
    }
}
