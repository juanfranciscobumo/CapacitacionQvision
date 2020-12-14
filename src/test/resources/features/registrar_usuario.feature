#language: es
#encoding: iso-8859-1
#Author: jbuiles@qvision.com.co, lvilla@qvision.com.co
Característica: Registrar usuario
  Yo quiero realizar el registro de un usuario

  Antecedentes: Endpoint
    Dado que se haya ingresado el endpoint del servicio

  @crearUsuario
  Esquema del escenario: Crear usuario
    Cuando el usuario '<nombre>' ingrese su trabajo '<trabajo>'
    Entonces el usuario '<nombre>' verá el trabajo '<trabajo>' creado exitosamente '<respuesta>'

    @desarrollo
    Ejemplos: Registrar usuario
      | nombre | trabajo | respuesta |
      | morfeo | líder   | OK        |

    @laboratorio
    Ejemplos: Registrar usuario
      | nombre | trabajo | respuesta |
      | ana    | líder   | OK        |

  @loguearse
  Esquema del escenario: Loguearse
    Cuando el usuario inicie sesión erroneamente
      | email   |
      | <email> |
    Entonces el usuario vera el mensaje de error '<mensajeError>'

    @desarrollo
    Ejemplos: Registrar usuario
      | email              | mensajeError |
      | eve.holt@reqres.in | BAD_REQUEST  |

    @laboratorio
    Ejemplos: Registrar usuario
      | email              | mensajeError |
      | maria@reqres.in | BAD_REQUEST  |





