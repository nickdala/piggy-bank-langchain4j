import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import AccountRecord from "Frontend/generated/com/nickthecloudguy/services/AccountService/AccountRecord"
import { AccountService } from "Frontend/generated/endpoints";
import { useEffect, useState } from "react";

interface AccountsViewProps {
    customerId: number;
}

export default function AccountsView(props: AccountsViewProps) {
    const [accounts, setAccounts] = useState<AccountRecord[]>([]);

    useEffect(() => {
        AccountService.findAllAccountsForCustomer(props.customerId).then(setAccounts);
    }, [props.customerId]);

    return (
        <div>
            <h3 className="text-l m-0">Accounts</h3>
            <Grid
                items={accounts}>
                <GridColumn path="id" header="Account ID" />
                <GridColumn path="accountType" header="Type" />
                <GridColumn path="balance" header="Balance" />
                <GridColumn path="accountStatus" header="Status" />
            </Grid>
        </div>
    );
}
