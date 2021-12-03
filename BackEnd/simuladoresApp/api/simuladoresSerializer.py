from simuladoresApp.models import Simuladores
from rest_framework import serializers

class SimuladoresSerializer(serializers.ModelSerializer):
   class Meta:
      model = Simuladores
      fields = ('nombre', 'descripcion', 'simulador')