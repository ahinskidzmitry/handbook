import type { Department } from "./Department";
import type { Profession } from "./Profession";

export interface Employee {
    id: number;
    name: string;
    profession: Profession;
    department: Department;
    note: string;
}