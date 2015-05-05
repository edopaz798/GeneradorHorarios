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
import co.edu.ucc.semillero.generadorhorarios.servicios.*;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Clase para ejecutar las pruebas, donde se encuentras los parametros de
 * ejecucion
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbMain")
@ViewScoped
public class Main {

    final static int INDIVIDUO_ELITE = 5;
    final static int TAMANO_POBLACION = 200 + INDIVIDUO_ELITE;  // tamano de la poblacion
    final static int MAX_ITERACIONES = 2000;             // numero maximo de iteraciones
    final static double TASA_MUTACION = 0.05;     // probabilidad de mutaciones
    final static double TASA_CRUZAMIENTO = 0.7;     // probabilidad de cruzamientos

    private final static Random random = new Random();  // generador de numeros aleatorios

    private List<DetalleHorario> detalleHorarios;
    private List<Dia> dias;
    private List<Hora> horas;
    private List<Salon> salones;

    @EJB
    private LogicaDetalleHorario logicaDetalleHorario;
    @EJB
    private LogicaDia logicaDia;
    @EJB
    private LogicaHora logicaHora;
    @EJB
    private LogicaSalon logicaSalon;

    /**
     * Metodo que inicializa las listas que contienen los datos presentes en la
     * base de datos
     *
     * @since 1.0.0
     */
    public void iniciar() {
        detalleHorarios = logicaDetalleHorario.consultarDetalleHorarios();
        dias = logicaDia.consultarDias();
        horas = logicaHora.consultarHoras();
        salones = logicaSalon.consultarSalons();
    }

    /**
     * Metodo que ejecuta el algoritmo genetico con los parametros establecidos
     * para la prueba.
     * 
     * @since 1.0.0
     */
    public void test() {
        iniciar();
        Poblacion pob = new Poblacion(TAMANO_POBLACION, detalleHorarios, dias, horas, salones);
        Individuo[] nuevaPoblacion = new Individuo[TAMANO_POBLACION];
        Individuo[] indiv = new Individuo[2];

        // poblacion actual
        System.out.print("Fitness Total= " + pob.getFitnessTotal());
        System.out.println(" ; Mejor Individuo = " + pob.mejorIndividuo().getValorFitness());

        // Ciclo Principal
        int count;
        for (int iteracion = 0; iteracion < MAX_ITERACIONES; iteracion++) {
            count = 0;

            // Elitismo
            for (int i = 0; i < INDIVIDUO_ELITE; ++i) {
                nuevaPoblacion[count] = pob.mejorIndividuo();
                count++;
            }

            // Generar nueva poblacion
            while (count < TAMANO_POBLACION) {
                // Seleccion
                indiv[0] = pob.ruleta();
                indiv[1] = pob.ruleta();

                // Cruzamiento
                if (random.nextDouble() < TASA_CRUZAMIENTO) {
                    indiv = pob.cruze(indiv[0], indiv[1]);
                }

                // Mutacion
                if (random.nextDouble() < TASA_MUTACION) {
                    indiv[0].mutacion(detalleHorarios, dias, horas, salones);
                }
                if (random.nextDouble() < TASA_MUTACION) {
                    indiv[1].mutacion(detalleHorarios, dias, horas, salones);
                }

                // agregar a la nueva poblacion
                nuevaPoblacion[count] = indiv[0];
                nuevaPoblacion[count + 1] = indiv[1];
                count += 2;
            }
            pob.setPoblacion(nuevaPoblacion);

            // reevaluar poblacion actual
            pob.evaluar();
            System.out.print("Fitness Total = " + pob.getFitnessTotal());
            System.out.println(" ; Mejor Individuo= " + pob.mejorIndividuo().getValorFitness());
        }

        // mejor individuo
        Individuo mejorIndividuo = pob.mejorIndividuo();
    }
}
