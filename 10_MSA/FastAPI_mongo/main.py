from fastapi import FastAPI
from routes import product, boxoffice, nsmc_ml
from apscheduler.schedulers.background import BackgroundScheduler
from scheduler.molvie import fetch_and_store

app = FastAPI()
app.include_router(product.router)
app.include_router(boxoffice.router)
app.include_router(nsmc_ml.router)

scheduler = BackgroundScheduler()
scheduler.add_job(fetch_and_store, 'cron', hour=12, minute=46)
scheduler.start()

@app.get("/")
async def start():
    return "Server is Running"

