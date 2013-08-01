/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author yepesk8r
 */
@Stateless
//con la siguiente anotación se indica que este recurso se accesará vía web desde la ruta /factorial
@Path("/vivienda")
public class Creditos {
    
    
//Se crea el método GET que recibe el parámetro numero.
    @GET
    public String vivienda(@QueryParam("monto")long monto, @QueryParam("id")String id) {
        String cedula =id;
        double re1 =0.05 * monto;
        int re = (int)re1;
        CreditoHelper creditohelper=new CreditoHelper();
        Credito credito = new Credito();
        credito.setId(cedula);
        credito.setMonto(monto);
        credito.setInteres(re);
        credito.setTipo("vivienda");
        System.out.println(credito.getId()+credito.getTipo()+credito.getInteres()+credito.getMonto());
        creditohelper.crear(credito);
        return calcular(monto,0.05);
    }
    
    @Path("/libreinversion") 
    @GET
    public String libreinversion(@QueryParam("monto")long monto, @QueryParam("id")String id) {
        String cedula =id;
        double re1 =0.05 * monto;
        int re = (int)re1;
        CreditoHelper creditohelper=new CreditoHelper();
        Credito credito = new Credito();
        credito.setId(cedula);
        credito.setMonto(monto);
        credito.setInteres(re);
        credito.setTipo("libreinversion");
        System.out.println(credito.getId()+credito.getTipo()+credito.getInteres()+credito.getMonto());
        creditohelper.crear(credito);
        return calcular(monto,0.07);
    }
     
   @Path("/vehiculo")
    @GET
    public String vehiculo(@QueryParam("monto")long monto, @QueryParam("id")String id) {
        String cedula =id;
        double re1 =0.05 * monto;
        int re = (int)re1;
        CreditoHelper creditohelper=new CreditoHelper();
        Credito credito = new Credito();
        credito.setId(cedula);
        credito.setMonto(monto);
        credito.setInteres(re);
        credito.setTipo("vehiculo");
        System.out.println(credito.getId()+credito.getTipo()+credito.getInteres()+credito.getMonto());
        creditohelper.crear(credito);
        return calcular(monto,0.10);
    }

    String calcular(long monto, double tasa) {
        
        double interes = monto*(tasa);
        double total =monto+interes;
        String mensaje = "el total de interes es"+interes+" y el total a pagar al final del mes es"+total;
        return mensaje;
      
    }
}

