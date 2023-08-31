select a.*, b.barcode, c.info, d.descrizione, d.aliquota
from public.articoli a
join public.barcode b on a.codart = b.codart
join public.ingredienti c on a.codart = c.codart
join public.iva d on a.idIva = d.idIva
where a.CODART = '123Test';