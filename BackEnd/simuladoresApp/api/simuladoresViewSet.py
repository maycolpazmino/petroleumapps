from rest_framework import viewsets

from simuladoresApp.models import Simuladores
from simuladoresApp.api.simuladoresSerializer import SimuladoresSerializer

class SimuladoresViewSet(viewsets.ModelViewSet):
   queryset = Simuladores.objects.all()
   serializer_class = SimuladoresSerializer