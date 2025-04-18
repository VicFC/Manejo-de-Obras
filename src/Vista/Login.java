/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Negocio.Obra;
import Modelo.*;
import Negocio.*;
import java.util.Calendar;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
Interfaz gráfica para el III Proyecto (Puestos en Obra de Construcción: Riesgos y Medidas)
 */
public class Login extends javax.swing.JFrame {

    /**
     * Clase de Login, en la cual se instancian los objetos a emplear.
     */
    
     // Crear una nueva obra
     Obra obra = new Obra("Obra Noviembre", "19892005");
     
    public Login() throws Exception {
        // obra.cargarPlanillas();
        System.out.println("\nSE CREA BIEN LA OBRA? \nNombre obra:" + obra.getNombre());
        
        obra.setCodigo("1989-2005");       

        // Mostrar cantidad de casilleros disponibles al inicio
        System.out.println("Codigo obra ahora: " + obra.getCodigo());
        
        /*
        // Instanciando puestos
        ArrayList<Puesto> puestos = new ArrayList<>();
        
        ///////////////ALBAÑIL/////////////////////////
        Puesto albanil = new Albanil();
        albanil.setCodigo(1);
        albanil.setNombre("Albañil");
        albanil.setDescripcion("""
                               Encargado de elaborar pastas, morteros, adhesivos, hormigones y de realizar diversos trabajos en obras. 
                               Caracterizado por la habilidad manual y destreza física para manejar herramientas, materiales pesados y trabajos de precisión en distintas posiciones.""");
        
        //   - Riesgos:
        ArrayList<Riesgo> riesgosAlbanil = new ArrayList<>();
        Riesgo ALBANILSobreesfuerzo = new Riesgo ("sobreesfuerzo");
        Riesgo ALBANILCaida = new Riesgo ("Caídas y golpes por objetos en caída");
        Riesgo ALBANILQuimicos = new Riesgo ("Exposición a polvos y productos químicos");
        Riesgo ALBANILElectricidad = new Riesgo ("Electrocución");
        riesgosAlbanil.add(ALBANILSobreesfuerzo);
        riesgosAlbanil.add(ALBANILCaida);
        riesgosAlbanil.add(ALBANILQuimicos);
        riesgosAlbanil.add(ALBANILElectricidad);
        albanil.setRiesgos(riesgosAlbanil);
               
        //   - Medidas:
        ArrayList<Medida> medidasAlbanil = new ArrayList<>();
        Medida ALBANILtecnicas = new Medida ("Aplicar técnicas de levantamiento seguro, cómo doblar las rodillas al cargar objetos pesados y asegurar descansos regulares para evitar la fatiga muscular.");
        Medida ALBANILmascarilla = new Medida ("Usar mascarillas y gafas de protección.");
        Medida ALBANILcasco = new Medida ("Portar siempre casco de seguridad.");
        Medida ALBANILandamios = new Medida ("Mantener siempre los andamios y escaleras en buen estado. ");
        medidasAlbanil.add(ALBANILtecnicas);
        medidasAlbanil.add(ALBANILmascarilla);
        medidasAlbanil.add(ALBANILcasco);
        medidasAlbanil.add(ALBANILandamios);
        albanil.setMedidas(medidasAlbanil);
        
        albanil.setRutaImagen("/images/Albanil.png");
        
        ////////////////CRISTALERO///////////////////////
        Puesto cristalero = new Cristalero();
        cristalero.setCodigo(2);
        cristalero.setNombre("Cristalero");
        cristalero.setDescripcion("""
                                 Encargado de trabajar con vidrios, cristales o cerámicas. 
                                 Este trabajo es sumamente riesgoso por la naturaleza cortante del vidrio y la maquinaria que se necesita para trabajar con el mismo.
                               """);
        
        //   - Riesgos:
        ArrayList<Riesgo> riesgosCristalero = new ArrayList<>();
        Riesgo CRISTALEROCaida = new Riesgo ("Caída");
        Riesgo CRISTALEROContusiones = new Riesgo ("Contusiones");
        Riesgo CRISTALEROGolpes = new Riesgo ("Golpes");
        Riesgo CRISTALEROparticulas = new Riesgo ("Exposición a partículas en suspensión");
        Riesgo CRISTALEROruido = new Riesgo ("Daños en el oido por ruido excesivo");
        riesgosCristalero.add(CRISTALEROCaida);
        riesgosCristalero.add(CRISTALEROContusiones);
        riesgosCristalero.add(CRISTALEROGolpes);
        riesgosCristalero.add(CRISTALEROparticulas);
        riesgosCristalero.add(CRISTALEROruido);
        cristalero.setRiesgos(riesgosCristalero);
        
        //   - Medidas:
        ArrayList<Medida> medidasCristalero = new ArrayList<>();
        Medida CRISTALEROguantes = new Medida ("Guantes");
        Medida CRISTALEROropa = new Medida ("Ropa de seguridad");
        Medida CRISTALEROmanguitos = new Medida ("Manguitos anti-corte");
        Medida CRISTALEROmunyequeras = new Medida ("Muñequeras");
        Medida CRISTALEROgafas = new Medida ("Gafas");
        Medida CRISTALEROmascarilla = new Medida ("Mascarilla");
        Medida CRISTALEROcalzado = new Medida ("Calzado de seguridad");
        Medida CRISTALEROtapones = new Medida ("Tapones para los oídos");
        medidasCristalero.add(CRISTALEROguantes);
        medidasCristalero.add(CRISTALEROropa);
        medidasCristalero.add(CRISTALEROmanguitos);
        medidasCristalero.add(CRISTALEROmunyequeras);
        medidasCristalero.add(CRISTALEROgafas);
        medidasCristalero.add(CRISTALEROmascarilla);
        medidasCristalero.add(CRISTALEROcalzado);
        medidasCristalero.add(CRISTALEROtapones);        
        cristalero.setMedidas(medidasCristalero);
        
        cristalero.setRutaImagen("/images/Cristalero.png");
        
        
        ////////////////JEFE DE OBRA///////////////////////
        Puesto jefeDeObra = new JefeDeObra();
        jefeDeObra.setCodigo(3);
        jefeDeObra.setNombre("Jefe de Obra");
        jefeDeObra.setDescripcion("""
                                Encargado de supervisar y planificar un proyecto de construcción. 
                                Este es responsable de gestionar aspectos importantes como el presupuesto, los materiales disponibles y la disponibilidad de los empleados.
                                Toma decisiones estratégicas, como discutir con el empleador o consultar información relevante con los arquitectos e ingenieros del proyecto.""");
        
        //   - Riesgos:
        ArrayList<Riesgo> riesgosJefeObra = new ArrayList<>();
        Riesgo JEFECaida = new Riesgo ("Caída");
        Riesgo JEFEHundimientos = new Riesgo ("Hundimientos");
        Riesgo JEFEDesprendimientos = new Riesgo ("Desprendimientos");
        Riesgo JEFEAtrapamientos = new Riesgo ("Atrapamientos");
        Riesgo JEFEExplosiones = new Riesgo ("Explosiones");
        Riesgo JEFEAtropellos  = new Riesgo ("Atropellos ");        
        riesgosJefeObra.add(JEFECaida);
        riesgosJefeObra.add(JEFEHundimientos);
        riesgosJefeObra.add(JEFEDesprendimientos);
        riesgosJefeObra.add(JEFEAtrapamientos);
        riesgosJefeObra.add(JEFEExplosiones);
        riesgosJefeObra.add(JEFEAtropellos);        
        jefeDeObra.setRiesgos(riesgosJefeObra);
        
        //   - Medidas:
        ArrayList<Medida> medidasJefeObra = new ArrayList<>();
        Medida JEFEcasco = new Medida ("Casco");
        Medida JEFEguantes = new Medida ("Guantes");
        Medida JEFEprotectores = new Medida ("Protectores auditivos");
        Medida JEFEarnes = new Medida ("Arnés");
        Medida JEFEplan = new Medida ("Plan de seguridad para cada zona de trabajo");
        medidasJefeObra.add(JEFEcasco);
        medidasJefeObra.add(JEFEguantes);
        medidasJefeObra.add(JEFEprotectores);
        medidasJefeObra.add(JEFEarnes);
        medidasJefeObra.add(JEFEplan);
        jefeDeObra.setMedidas(medidasJefeObra);
         
        jefeDeObra.setRutaImagen("/images/Jefe.png");
        
        /////////////////SOLDADOR///////////////////////
        Puesto soldador = new Soldador();
        soldador.setCodigo(4);
        soldador.setNombre("Soldador");
        soldador.setDescripcion("""
                               Encargado de unir piezas metálicas que forman parte del componente estructural.
                               Se trata de un trabajo sumamente riesgoso debido a la naturaleza de sus obligaciones y a los equipos que emplean.
                               Desempeñan una labor riesgosa para la vista.""");
        
        // poner acá los riesgos y medidas
        //   - Riesgos:
        ArrayList<Riesgo> riesgosSoldador = new ArrayList<>();
        Riesgo SOLDADORCaida = new Riesgo ("Caída");
        Riesgo SOLDADORHumo = new Riesgo ("Exposición a humo y gases");
        Riesgo SOLDADORQuemaduras = new Riesgo ("Quemaduras");
        Riesgo SOLDADOROculares = new Riesgo ("Lesiones oculares");
        Riesgo SOLDADORElectricidad = new Riesgo ("Electrocución");
        Riesgo SOLDADORRuido = new Riesgo ("Daños en el oido por ruidos fuertes");
        riesgosSoldador.add(SOLDADORCaida);
        riesgosSoldador.add(SOLDADORHumo);
        riesgosSoldador.add(SOLDADORQuemaduras);
        riesgosSoldador.add(SOLDADOROculares);
        riesgosSoldador.add(SOLDADORElectricidad);
        riesgosSoldador.add(SOLDADORRuido);
        soldador.setRiesgos(riesgosSoldador);
        
        //   - Medidas:
        ArrayList<Medida> medidasSoldador = new ArrayList<>();
        Medida SOLDADORmascara = new Medida ("Máscara de soldador con filtros adecuados.");
        Medida SOLDADORguantes = new Medida ("Guantes.");
        Medida SOLDADORropa = new Medida ("Ropa ignífuga.");
        Medida SOLDADORbotas = new Medida ("Botas de seguridad.");
        Medida SOLDADORcasco = new Medida ("Portar siempre casco de seguridad.");
        Medida SOLDADORandamios = new Medida ("Mantener siempre los andamios y escaleras en buen estado. ");
        medidasSoldador.add(SOLDADORmascara);
        medidasSoldador.add(SOLDADORguantes);
        medidasSoldador.add(SOLDADORropa);
        medidasSoldador.add(SOLDADORbotas);
        medidasSoldador.add(SOLDADORcasco);
        medidasSoldador.add(SOLDADORandamios);        
        soldador.setMedidas(medidasSoldador);
        
        soldador.setRutaImagen("/images/Soldador.png");
        
        /////////////////ALTURAS///////////////////////
        Puesto trabajadorDeAlturas = new TrabajadorDeAlturas();
        trabajadorDeAlturas.setCodigo(5);
        trabajadorDeAlturas.setNombre("Trabajador de Alturas");
        trabajadorDeAlturas.setDescripcion("""
                                            Encargado de las tareas que están por encima del nivel del piso, como instalación de ventanas, techos, fachadas, estructuras pertinentes, etc. 
                                            Puesto con la posibilidad de caer a un nivel más bajo.""");
        
        //   - Riesgos:
        ArrayList<Riesgo> riesgosAlturas = new ArrayList<>();
        Riesgo ALTURAScaida = new Riesgo("Caída");
        Riesgo ALTURASDerrumbe = new Riesgo ("Derrumbes de estructuras");
        Riesgo ALTURASGolpes = new Riesgo ("Golpes por caída de objetos");
        Riesgo ALTURASAtrapamientos = new Riesgo ("Atrapamientos");
        Riesgo ALTURASElectricidad = new Riesgo ("Contacto eléctrico");        
        riesgosAlturas.add(ALTURAScaida);
        riesgosAlturas.add(ALTURASDerrumbe);
        riesgosAlturas.add(ALTURASGolpes);
        riesgosAlturas.add(ALTURASAtrapamientos);
        riesgosAlturas.add(ALTURASElectricidad);               
        trabajadorDeAlturas.setRiesgos(riesgosAlturas);
        
        //   - Medidas:
        ArrayList<Medida> medidasAlturas = new ArrayList<>();
        Medida ALTURAScapacitaciones = new Medida("Usar equipo bien mantenido");
        Medida ALTURASproteccion = new Medida("Usar equipo de arnés");
        Medida ALTURASzonasPeligro = new Medida("Tener zonas de peligro bien demarcadas");
        Medida ALTURAScasco = new Medida("Portar casco");        
        medidasAlturas.add(ALTURAScapacitaciones);
        medidasAlturas.add(ALTURASproteccion);
        medidasAlturas.add(ALTURASzonasPeligro);
        medidasAlturas.add(ALTURAScasco);             
        trabajadorDeAlturas.setMedidas(medidasAlturas);
        
        trabajadorDeAlturas.setRutaImagen("/images/Alturas.png");
        
        // AGREGANDO A LOS PUESTOS:
        puestos.add(albanil);
        puestos.add(cristalero);
        puestos.add(jefeDeObra);
        puestos.add(soldador);
        puestos.add(trabajadorDeAlturas);
      
        // Crear una fecha plantilla
        Calendar fechaIngreso = Calendar.getInstance();
        fechaIngreso.set(1990, Calendar.JANUARY, 1);
        
        // Instanciando Empleados:
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado1 = new Empleado();
        empleado1.setId("E1111");
        empleado1.setNombre("Pedro Valenciaga");
        empleado1.setCorreo("pedro@obra.com");
        empleado1.setTelefono("55582000");
        empleado1.setDireccion("Sabanilla");
        empleado1.setFechaIngreso(fechaIngreso);
        empleado1.setPuesto(albanil);
        empleado1.setSalarioHora(25000.25);
        empleados.add(empleado1);
        
        Empleado empleado2 = new Empleado();
        empleado2.setId("E2222");
        empleado2.setNombre("Juan Vázquez");
        empleado2.setCorreo("juan@obra.com");
        empleado2.setTelefono("55772000");
        empleado2.setDireccion("Nosara");
        empleado2.setFechaIngreso(fechaIngreso);
        empleado2.setPuesto(cristalero);
        empleado2.setSalarioHora(14500.00);
        empleados.add(empleado2);
        
        Empleado empleado3 = new Empleado();
        empleado3.setId("E3333");
        empleado3.setNombre("Valeria Chompi");
        empleado3.setCorreo("valeps@obra.com");
        empleado3.setTelefono("99882000");
        empleado3.setDireccion("Tres Ríos");
        empleado3.setFechaIngreso(fechaIngreso);
        empleado3.setPuesto(jefeDeObra);
        empleado3.setSalarioHora(15000.50);
        empleados.add(empleado3);
        
        Empleado empleado4 = new Empleado();
        empleado4.setId("E4444");
        empleado4.setNombre("Luis Carlos Abarca");
        empleado4.setCorreo("luisca@obra.com");
        empleado4.setTelefono("77782000");
        empleado4.setDireccion("Curridabat");
        empleado4.setFechaIngreso(fechaIngreso);
        empleado4.setPuesto(soldador);
        empleado4.setSalarioHora(20000.50);
        empleados.add(empleado4);
        
        Empleado empleado5 = new Empleado();
        empleado5.setId("E5555");
        empleado5.setNombre("Diego de la Vega");
        empleado5.setCorreo("diegov@obra.com");
        empleado5.setTelefono("55582111");
        empleado5.setDireccion("San Francisco");
        empleado5.setFechaIngreso(fechaIngreso);
        empleado5.setPuesto(trabajadorDeAlturas);
        empleado5.setSalarioHora(17000);
        empleados.add(empleado5);
       
        // CONTRASEÑA: MÍN 8 CARACTERES, 2 DIGITOS Y UN SIMBOLO ESPECIAL
        
        // Instanciando Usuarios:
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario admin1 = new Usuario();
        admin1.setUsername("jorge_gomez");
        admin1.setNombre("Jorge Gómez");
        admin1.setPassword("12341234*");
        admin1.setRol(RolUsuario.ADMINISTRADOR);
        usuarios.add(admin1);
        
        Usuario admin2 = new Usuario();
        admin2.setUsername("esmeralda_delarosa");
        admin2.setPassword("12341234*");
        admin2.setNombre("Esmeralda De la Rosa");
        admin2.setRol(RolUsuario.ADMINISTRADOR);
        usuarios.add(admin2);
        
        // Instanciando Inspectores
        Usuario inspector1 = new Usuario();
        inspector1.setUsername("vegeta_777");
        inspector1.setNombre("Samuel Sibaja");
        inspector1.setPassword("12341234*");
        inspector1.setRol(RolUsuario.INSPECTOR);
        usuarios.add(inspector1);
        
        Usuario inspector2 = new Usuario();
        inspector2.setUsername("armando_mendoza");
        inspector2.setNombre("Armando Mendoza");
        inspector2.setPassword("12341234*");
        inspector2.setRol(RolUsuario.INSPECTOR);
        usuarios.add(inspector2);
        
        // Instanciando Usuarios:
        ArrayList<EntradaBitacora> bitacora = new ArrayList<>();
                         
        // Asignar las listas a la obra
        obra.setPlanillaEmpleados(empleados);
        obra.setListaUsuarios(usuarios);
        obra.setListaPuestos(puestos); 
        obra.setBitacora(bitacora);
        
        System.out.println("\nProbando instancias: ");
        System.out.println("\nEMPLEADOS: ");
        for (Empleado e : obra.getPlanillaEmpleados()) {
            System.out.println("ID: " + e.getId());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Correo: " + e.getCorreo());
        }
        System.out.println("\nUSUARIOS: ");
        for (Usuario u : obra.getListaUsuarios()) {
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Rol: " + u.getRol());
        }        
        System.out.println("\nPuestos: ");
        for (Puesto p : obra.getListaPuestos()) {
            System.out.println("Nombre: " + p.getNombre());
             for (Riesgo r : p.getRiesgos())
            {
            System.out.println("Riesgo: " + r.getNombre());
            }
            for (Medida m : p.getMedidas())
            {
            System.out.println("Medida: " + m.getNombre());
            }
        }        
        System.out.println("\nBitacora: ");
        bitacora.toString();
         
        // Guardar planillas en archivos
        obra.guardarPlanillas();
        
        */
        
        obra.cargarPlanillas();
        System.out.println("\nEMPLEADOS: ");
        for (Empleado e : obra.getPlanillaEmpleados()) {
           // e.setSalarioHora(25500.00);
            System.out.println("ID: " + e.getId());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Correo: " + e.getCorreo());
            System.out.println("Salario: " + e.getSalarioHora());
            System.out.println("Puesto: " + e.getPuesto().getNombre());
        }
        
        System.out.println("\nUSUARIOS: ");
        for (Usuario u : obra.getListaUsuarios()) {
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Rol: " + u.getRol());
            System.out.println("Contraseña: " + u.getPassword());
        }        
        System.out.println("\nPUESTOS: ");
        for (Puesto p : obra.getListaPuestos()) {
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Descripcion: " + p.getDescripcion());
            System.out.println("Imagen: " + p.getRutaImagen());
            for (Riesgo r : p.getRiesgos())
            {
            System.out.println("Riesgo: " + r.getNombre());
            }
            for (Medida m : p.getMedidas())
            {
            System.out.println("Medida: " + m.getNombre());
            }
        }    
         
        
        obra.guardarPlanillas();
        
           
        initComponents();
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImagenLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ComboBoxPerfilUsuario = new javax.swing.JComboBox<>();
        ButtonIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PasswordTextBox = new javax.swing.JPasswordField();
        UsernameTextBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido al sistema");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImagenLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Login.png"))); // NOI18N
        jPanel1.add(ImagenLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, 750, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 628, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        ComboBoxPerfilUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Inspector" }));
        ComboBoxPerfilUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPerfilUsuarioActionPerformed(evt);
            }
        });

        ButtonIngresar.setBackground(new java.awt.Color(0, 255, 51));
        ButtonIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonIngresar.setText("Ingresar");
        ButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIngresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Ingresar como:");

        jLabel3.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(ComboBoxPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(UsernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PasswordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UsernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PasswordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButtonIngresar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 356, 630, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxPerfilUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxPerfilUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxPerfilUsuarioActionPerformed

    private void ButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIngresarActionPerformed
    // Validar que se haya seleccionado algo en el ComboBox
    if (ComboBoxPerfilUsuario.getSelectedIndex() == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione un perfil de usuario.");
        return;
    }
    
    // Obtener los valores de los campos
    String username = UsernameTextBox.getText().trim();
    String password = new String(PasswordTextBox.getPassword()).trim();
    String rolSeleccionado = ComboBoxPerfilUsuario.getSelectedItem().toString();

    // Validar que no estén vacíos
    if (username.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }
    
     // Buscar en el ArrayList<Usuario>
    boolean usuarioEncontrado = false;
    for (Usuario usuario : obra.getListaUsuarios()) { 
        if (usuario.getUsername().equals(username) 
                && usuario.getPassword().equals(password) 
                && usuario.getRol().toString().equalsIgnoreCase(rolSeleccionado)) {
            usuarioEncontrado = true;
            break;
        }
    }
    
    // Mensaje según el resultado
    if (usuarioEncontrado) {
        if (rolSeleccionado.equalsIgnoreCase("Administrador"))
        {
          PrincipalAdmins verPrincipalAdmins = new PrincipalAdmins(obra);    
          verPrincipalAdmins.setVisible(true);
        }
        else if (rolSeleccionado.equalsIgnoreCase("Inspector"))
        {
          PrincipalInspectores verPrincipalInspectores = new PrincipalInspectores(obra);    
          verPrincipalInspectores.setVisible(true);
        }
        
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Credenciales incorrectas o usuario no encontrado. \nUsername debe estar en minúscula y con _ en los espacios.");
    }
        
    }//GEN-LAST:event_ButtonIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonIngresar;
    private javax.swing.JComboBox<String> ComboBoxPerfilUsuario;
    private javax.swing.JLabel ImagenLogin;
    private javax.swing.JPasswordField PasswordTextBox;
    private javax.swing.JTextField UsernameTextBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
