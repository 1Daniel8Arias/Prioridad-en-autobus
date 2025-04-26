# Instrucciones de Uso de la Aplicación de Abordaje de Autobús

## Tecnología Utilizada
- Lenguaje: **Java 24**
- Tecnologías de Interfaz: **JavaFX**

## Descripción General
Esta aplicación permite simular el proceso de abordaje de pasajeros en un autobús con capacidad para **19 pasajeros**.

Los pasajeros tienen prioridad según su tipo, y son ubicados en los asientos disponibles a medida que se realiza el abordaje.

## Instrucciones Paso a Paso

### 1. Agregar Pasajero
- Ingrese el **nombre del pasajero** en el campo de texto correspondiente.
- Seleccione el **tipo de pasajero** mediante los botones de opción disponibles:
  - Persona con discapacidad
  - Mujer embarazada
  - Adulto mayor
  - Pasajero común
- Haga clic en el botón **"Agregar"**.
- El pasajero se agregará a la **cola de abordaje**.
- Puede agregar hasta un **máximo de 19 pasajeros**.

### 2. Visualizar la Cola de Abordaje
- Cada vez que agregue un pasajero, se actualizará automáticamente la sección **"Cola de abordaje"**.
- Se mostrará el orden exacto en el que los pasajeros serán abordados, priorizando los pasajeros según su tipo.

### 3. Abordar Pasajero
- Haga clic en el botón **"Abordar siguiente"**.
- El primer pasajero en la cola abordará el autobús.
- El pasajero será asignado a un **asiento disponible**, según el orden de prioridad y disponibilidad.

### 4. Visualizar en el Tab de Autobús
- En el **tab "Vista del Autobús"**, verá cómo el asiento es ocupado por el nombre del pasajero.
- Cada asiento ocupado cambia de color para diferenciarlo de los asientos vacíos.

### 5. Visualizar en el Tab de Pasajeros Abordados
- En el **tab "Pasajeros Abordados"**, se mostrará:
  - El **nombre del pasajero**.
  - El **número de asiento** que le fue asignado.
- Esta lista se irá actualizando a medida que los pasajeros aborden.

### 6. Condiciones Especiales
- Si el autobús está **lleno** (19 asientos ocupados), no se podrá abordar más pasajeros.
- Si la **cola está vacía**, no se puede abordar ningún pasajero hasta agregar nuevos.

---

# Notas Importantes
- Cada pasajero debe tener un nombre único para identificarlo correctamente.
- Debe seleccionarse obligatoriamente un tipo de pasajero para poder agregarlo.
- El orden de abordaje sigue una **prioridad** según el tipo de pasajero.

---

¡Disfruta utilizando la simulación de abordaje en autobús! 🚌

