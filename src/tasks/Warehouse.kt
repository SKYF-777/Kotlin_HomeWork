package tasks

class Warehouse() {
    fun getPack (obj: DeliveryObject): Pack {
        return Pack(
            length = obj.length + 1,
            width = obj.width + 1,
            height = obj.height + 1,
            weight = 0.3
        )
    }

    fun packCargo(obj: DeliveryObject): Cargo {
        val pack = getPack(obj)
        val net = obj.weight
        val gross = obj.weight + pack.weight
        return Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePackaging = pack.type,
            netWeight = net,
            grossWeight = gross
        )
    }
}