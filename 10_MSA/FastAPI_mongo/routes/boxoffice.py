from database.mongo import products
from fastapi import APIRouter
from typing import Optional

router = APIRouter(
    prefix="/boxoffice",
    tags=["boxoffice"]
)

@router.get("/data")
def get_box_office(date: Optional[str] = None):
    query = {"date": date} if date else {}
    result = list(products.find(query, {"_id": 0}))
    return result