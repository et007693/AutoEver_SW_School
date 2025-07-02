from fastapi import APIRouter, HTTPException
from fastapi.responses import JSONResponse
from pydantic import BaseModel
from typing import List
from database.mongo import db, products

router = APIRouter(
    prefix="/product",
    tags=["product"]
)

class Product(BaseModel):
    name: str
    price: float
    quantity: int

def convert_doc(doc) :
    doc["id"] = str(doc["_id"])
    del doc["_id"]
    return doc

@router.post("/post", status_code=201)
def create_product(product: Product):
    data = product.dict()
    result = products.insert_one(data)
    return {"id" : str(result.inserted_id)}

@router.get("/list", response_model=List[Product])
def get_all_products():
    docs = products.find()
    return [convert_doc(doc) for doc in docs]

@router.get("/{name}", response_model=Product)
def get_product_by_name(name: str):
    doc = products.find_one({"name": name})
    if doc:
        return convert_doc(doc)
    else:
        raise  HTTPException(status_code=404, detail="Product not found")

