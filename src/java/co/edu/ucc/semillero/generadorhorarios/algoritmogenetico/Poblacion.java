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
 * Clase que maneja el funcionamiento de la poblacion.
 *
 * @author Eduardo Paz
 * @version 1.0.0
 */
public class Poblacion {

    private final int TAMANO_POBLACION;// tamano de la poblacion

    private static final Random random = new Random();  // generador de numeros aleatorios
    private final Individuo[] poblacion;
    private double fitnessTotal;

    /**
     *
     */
    public Poblacion(int TAMANO_POBLACION, List<DetalleHorario> detalleHorarios, List<Dia> dias, List<Hora> horas, List<Salon> salones) {
        this.TAMANO_POBLACION = TAMANO_POBLACION;

        poblacion = new Individuo[TAMANO_POBLACION];

        // inicializar poblacion
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            poblacion[i] = new Individuo();
            poblacion[i].genesAleatorios(detalleHorarios, dias, horas, salones);
        }

        // evaluar poblacion actual
        this.evaluar();

    }

    public void iniciar() {

    }

    public double getFitnessTotal() {
        return fitnessTotal;
    }

    /**
     *
     * @param nuevaPoblacion
     */
    public void setPoblacion(Individuo[] nuevaPoblacion) {
        System.arraycopy(nuevaPoblacion, 0, this.poblacion, 0, TAMANO_POBLACION);
    }

    /**
     *
     * @return
     */
    public Individuo[] getPoblacion() {
        return this.poblacion;
    }

    /**
     *
     * @return
     */
    public double evaluar() {
        this.fitnessTotal = 0.0;
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            this.fitnessTotal += poblacion[i].evaluar();
        }
        return this.fitnessTotal;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public Individuo mejorIndividuo() {
        int indiceMax = 0, indiceMin = 0;
        double maxActual = 0.0;
        double minActual = 1.0;
        double valorActual;

        for (int i = 0; i < TAMANO_POBLACION; ++i) {
            valorActual = poblacion[i].getValorFitness();
            if (maxActual < minActual) {
                maxActual = minActual = valorActual;
                indiceMax = indiceMin = i;
            }
            if (valorActual > maxActual) {
                maxActual = valorActual;
                indiceMax = i;
            }
            if (valorActual < minActual) {
                minActual = valorActual;
                indiceMin = i;
            }
        }

        return poblacion[indiceMin];      // minimizar
        //return poblacion[indiceMax];        // maximizar
    }

    /**
     *
     * @param indiv1
     * @param indiv2
     * @return
     */
    public Individuo[] cruze(Individuo indiv1, Individuo indiv2) {
        Individuo[] newIndiv = new Individuo[2];
        newIndiv[0] = new Individuo(indiv1.getGenesSize());
        newIndiv[1] = new Individuo(indiv1.getGenesSize());
        int puntoCorte = random.nextInt(newIndiv[0].getGenesSize());
        int i;
        for (i = 0; i < puntoCorte; ++i) {
            newIndiv[0].setGene(i, indiv1.getGene(i));
            newIndiv[1].setGene(i, indiv2.getGene(i));
        }
        for (; i < newIndiv[0].getGenesSize(); ++i) {
            newIndiv[0].setGene(i, indiv2.getGene(i));
            newIndiv[1].setGene(i, indiv1.getGene(i));
        }

        return newIndiv;
    }
}
