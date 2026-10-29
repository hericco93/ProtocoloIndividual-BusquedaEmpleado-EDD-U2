# Control de Empleados - Algoritmos de Búsqueda y Ordenamiento

**Asignatura:** Estructuras de Datos  
**Programa:** Ingeniería de Software  
**Institución:** Universidad de Cartagena  
**Ejercicio Asignado:** N° 21 - Control de Empleados

---

## Descripción del Proyecto
Este proyecto implementa un sistema en Java para el registro y gestión de un conjunto de objetos `Empleado` (atributos: identificación, nombre, cargo y salario). Se aplican manualmente algoritmos de búsqueda y ordenamiento sobre arreglos de objetos, evaluando la precondición de ordenamiento y comparando el rendimiento experimental de las búsquedas secuencial y binaria.

## Funcionalidades Implementadas
1. **Búsqueda lineal por ID:** Localización exacta en datos desordenados $O(n)$.
2. **Búsqueda por cargo:** Filtro secuencial de múltiples coincidencias parciales/totales.
3. **Ordenamiento por identificación:** Algoritmo de ordenamiento por inserción.
4. **Búsqueda binaria por ID:** Algoritmo eficiente $O(\log n)$ sobre arreglo ordenado.
5. **Análisis de Rendimiento:** Comparativa de tiempo ($\text{ms}$) y comparaciones entre Búsqueda Lineal y Binaria en arreglos masivos de $1.000$, $50.000$ y $200.000$ registros.

## Instrucciones de Ejecución
1. **Requisitos:** Java SDK 17 o superior.
2. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/hericco93/ProtocoloIndividual-BusquedaEmpleado-EDD-U2.git]