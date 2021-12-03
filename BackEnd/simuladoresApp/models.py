from django.db import models
from usersApp.models import User

class Simuladores(models.Model):
   user = models.ForeignKey(User, on_delete=models.CASCADE,verbose_name = 'Usuario', null = True)
   nombre = models.CharField(max_length=50)
   descripcion = models.TextField()
   simulador = models.URLField(max_length=200)

   class Meta:
        """Meta definition for Simuladores."""

        verbose_name = 'Simulador'
        verbose_name_plural = 'Simuladores'

   def __str__(self):
        """Unicode representation of Simuladores."""
        return self.nombre