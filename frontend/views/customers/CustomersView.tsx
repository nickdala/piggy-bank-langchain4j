import CustomerRecord from "Frontend/generated/com/nickthecloudguy/services/CustomerService/CustomerRecord";
import { CustomerService } from "Frontend/generated/endpoints";
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import { useEffect, useState } from "react";
import AccountsView from "Frontend/views/customers/AccountsView";

export default function CustomersView() {
    const [customers, setCustomers] = useState<CustomerRecord[]>([]);
    const [selected, setSelected] = useState<CustomerRecord | null | undefined>(null);

    useEffect(() => {
        CustomerService.findAllCustomers().then(setCustomers);
    }, []);

    return (
        <div>
            <h3 className="text-l m-0">Customers</h3>
            <Grid
                items={customers}
                onActiveItemChanged={e => setSelected(e.detail.value)}
                selectedItems={[selected]}>

                <GridColumn path="id" header="Customer ID" />
                <GridColumn path="firstName" header="First Name" />
                <GridColumn path="lastName" header="Last Name" />
                <GridColumn path="email" header="Email" />
            </Grid>

            {selected &&
                <AccountsView accounts={selected.accounts} />
            }
        </div>
    );
}
