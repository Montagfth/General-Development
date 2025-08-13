# Ejemplo de un decorador en Python
def decoradorEjemplo(funcion):
    def funcionDecoradora():
        print("Antes de llamar a la función")
        funcion()
        print("Después de llamar a la función")
    return funcionDecoradora

# Llamaada al decorador por notación "@":


@decoradorEjemplo
def saludar():
    print("Hola mundo!")


# Invocación de la función decorada:
saludar()
