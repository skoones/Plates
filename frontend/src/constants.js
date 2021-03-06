import Vue from "vue";

export const VEGETARIAN = 'vegetarian';
export const VEGAN = 'vegan';
export const LOW_CALORIE = 'low-calorie';

export const BREAKFAST = 'breakfast';
export const SNACK_1 = 'snack 1';
export const SNACK_2 = 'snack 2';
export const LUNCH = 'lunch';
export const DINNER = 'dinner';
export const SNACK = 'snack';

export const MEAL_TYPES = [
    BREAKFAST,
    SNACK,
    LUNCH,
    DINNER
];

export const DIETS = [
    VEGETARIAN,
    VEGAN,
    LOW_CALORIE
];

export const DAILY_MEALS = [
    BREAKFAST,
    SNACK_1,
    LUNCH,
    SNACK_2,
    DINNER
];

export const MAP_FROM_GROUP_TO_MEAL_TYPE = new Map([
    ['Breakfasts', BREAKFAST],
    ['Snacks', SNACK],
    ['Lunches', LUNCH],
    ['Dinners', DINNER]
]);

export const MEAL_TYPE_TO_GROUP_NAME = new Map([
    [BREAKFAST, 'Breakfasts'],
    [SNACK_1, 'Snacks'],
    [LUNCH, 'Lunches'],
    [SNACK_2, 'Snacks'],
    [DINNER, 'Dinners']
]);

export const MAP_MEAL_TYPE_TO_ENDPOINT = new Map([
    [BREAKFAST, 'breakfast'],
    [SNACK_1, 'snack'],
    [SNACK_2, 'snack'],
    [SNACK, 'snack'],
    [LUNCH, 'lunch'],
    [DINNER, 'dinner']
]);

export const MEAL_TYPE_TO_ICON = new Map([
    [BREAKFAST, 'mdi-toaster'],
    [SNACK_1, 'mdi-food-apple'],
    [LUNCH, 'mdi-pasta'],
    [SNACK_2, 'mdi-food-apple'],
    [DINNER, 'mdi-silverware']
]);

export const DIET_TYPE_TO_ICON = new Map([
    [VEGAN, 'mdi-leaf'],
    [VEGETARIAN, 'mdi-food-steak-off'],
    [LOW_CALORIE, 'mdi-feather']
]);

export const DAYS_OF_WEEK = [
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday',
    'Sunday'
];

export const EventBus = new Vue();