package com.example.vk.android.homework

data class AppItem(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val icon: String
)

val appList = listOf(
    AppItem(
        id = "1",
        name = "СберБанк Онлайн",
        description = "Больше чем банк",
        category = "Финансы",
        icon = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp"
    ),
    AppItem(
        id = "2",
        name = "ВКонтакте: чаты, видео, музыка",
        description = "Социальная сеть для общения, музыки, видео и сообществ",
        category = "Общение",
        icon = "https://static.rustore.ru/imgproxy/PTo8g-Giv9VHYo7_Rwxw_1wC07KtDM7eSJgAfMlv53s/preset:web_app_icon_160/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp"
    ),
    AppItem(
        id = "3",
        name = "Авито – услуги, работа, авто",
        description = "Площадка для покупки и продажи товаров и услуг",
        category = "Объявления и услуги",
        icon = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp"
    ),
    AppItem(
        id = "4",
        name = "2ГИС: навигатор, транспорт, друзья на карте",
        description = "Карта, навигатор, общественный транспорт, путеводитель, справочник",
        category = "Транспорт и навигация",
        icon = "https://static.rustore.ru/imgproxy/OYKFMgpckkNGCd1jKcnHKojgnsMJ09qjfr9TYyjkyx4/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/2/1e/apk/260799/content/ICON/8e439c58-11cf-4e0a-a3dc-9596eda08cfd.png@webp"
    ),
    AppItem(
        id = "5",
        name = "VK Видео: кино, сериалы, ТВ и мультфильмы",
        description = "Платформа для просмотра фильмов и сериалов",
        category = "Развлечения",
        icon = "https://static.rustore.ru/imgproxy/rdEDV2Fz6KXF-iAUnqBOqBWnBOYt4lNT2RZa4409xNI/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp"
    ),
    AppItem(
        id = "6",
        name = "ВТБ Онлайн",
        description = "Мобильный банк для управления счётом и переводов",
        category = "Финансы",
        icon = "https://static.rustore.ru/imgproxy/LguGaWMo4tYwKcTnnlWnDSSFDyUX1B_kxPoWNteyPeI/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/404415/content/ICON/867b6386-687d-4d6f-a686-4ee98c04b859.png@webp"
    ),
    AppItem(
        id = "7",
        name = "VK Музыка: аудиокниги, песни, подкасты",
        description = "Стриминговый сервис с музыкой и подкастами",
        category = "Развлечения",
        icon = "https://static.rustore.ru/imgproxy/LE2WvUhdzFAPnlmyXo96GlCwhB1gN5juRDJmWdvzFXw/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/2/10/ae/apk/313279/content/ICON/62b9b0e2-0e7c-4855-a70d-9d6811fa3b4c.jpg@webp"
    ),
    AppItem(
        id = "8",
        name = "Mail: Почта, Облако, Календарь",
        description = "Почта Mail — ваш быстрый и удобный почтовый клиент",
        category = "Полезные инструменты",
        icon = "https://static.rustore.ru/imgproxy/2wnsbc-wCmdbFYEdpH8uL3Jl4db6i7HE9Vj5079oh6Q/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp"
    ),
    AppItem(
        id = "9",
        name = "Т-Банк",
        description = "Т-Банк — лучшее приложение для жизни",
        category = "Финансы",
        icon = "https://static.rustore.ru/imgproxy/qqoP1Cyi4tplnwb8Z_yJ2mnWVhuen4kzin6tQLWsSHY/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp"
    ),
    AppItem(
        id = "10",
        name = "Яндекс Карты и Навигатор",
        description = "Яндекс Карты построят маршруты на чём угодно",
        category = "Транспорт и навигация",
        icon = "https://static.rustore.ru/imgproxy/kN8NuYdJ6YTyb8oR90TnHIesgx8g2OUJg0ktaqwkM84/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/586431/content/ICON/a5f2fe7d-cd63-4f3f-a2f8-40d997c1d6f4.png@webp"
    )
)
