export interface Department {
    id: number;
    name: string;
    note: string;
    parentId: number;
    children: Department[];
}