from rest_framework.routers import DefaultRouter

from usersApp.api.api import UserViewSet
from simuladoresApp.api.simuladoresViewSet import SimuladoresViewSet

router = DefaultRouter()

router.register(r'usuarios', UserViewSet, basename="users")
router.register(r'simuladores',SimuladoresViewSet,basename = 'simuladores')

urlpatterns = router.urls